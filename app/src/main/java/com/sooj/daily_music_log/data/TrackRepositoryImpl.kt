package com.sooj.daily_music_log.data

import com.sooj.daily_music_log.BuildConfig
import com.sooj.daily_music_log.domain.TrackRepository
import com.sooj.daily_music_log.domain.api_model.Album
import com.sooj.daily_music_log.domain.api_model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val musicApi : ApiService_endPoint,
) : TrackRepository {
    override suspend fun getMusic_impl(track: String): List<Track> {
        return withContext(Dispatchers.IO) {
            val searchResponse = musicApi.getTrackSearch(
                "track.search", track, BuildConfig.LAST_FM_API_KEY, "json"
            )
            if ( searchResponse.isSuccessful) {
                /** 응답 성공 시 */
                val searchList = searchResponse.body()?.results?.trackmatches?.track
                searchList ?: emptyList()

            } else {
                /** 에러 */
                emptyList()
            }
        }
    }

    override suspend fun getPoster_impl(track: String, artist: String): Album? {
        TODO("Not yet implemented")
    }

    override suspend fun saveSelected_impl() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTracks_impl() {
        TODO("Not yet implemented")
    }
}