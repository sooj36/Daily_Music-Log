package com.sooj.daily_music_log.data

import android.util.Log
import com.sooj.daily_music_log.BuildConfig
import com.sooj.daily_music_log.domain.TrackRepository
import com.sooj.daily_music_log.domain.api_model.Album
import com.sooj.daily_music_log.domain.api_model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val musicApi: ApiService_endPoint,
//    private val trackDao : TrackDao
) : TrackRepository {
    override suspend fun getMusic_impl(track: String): List<Track> {
        return withContext(Dispatchers.IO) {
            val searchResponse = musicApi.getTrackSearch(
                "track.search", track, BuildConfig.LAST_FM_API_KEY, "json"
            )
            if (searchResponse.isSuccessful) {
                val searchList = searchResponse.body()?.results?.trackmatches?.track
                searchList ?: emptyList()
            } else {
                Log.e("sj getmusic error", "get music error ${searchResponse.code()}")
                emptyList()
            }
        }
    }

    override suspend fun getPoster_impl(track: String, artist: String): Album? {
        return withContext(Dispatchers.IO) {
            try {
                val posterResponse = musicApi.getPostInfo(
                    "track.getInfo", BuildConfig.LAST_FM_API_KEY, artist, track, "json"
                )
                if (posterResponse.isSuccessful) {
                    val album = posterResponse.body()?.track?.album
                    album
                } else {
                    Log.e("sj poster error", "get music error ${posterResponse.code()}")
                    null
                }
            } catch (e: Exception) {
                Log.e("sj poster error", "${e.message}")
                null
            }
        }
    }

    override suspend fun saveSelected_impl() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTracks_impl() {
        TODO("Not yet implemented")
    }
}