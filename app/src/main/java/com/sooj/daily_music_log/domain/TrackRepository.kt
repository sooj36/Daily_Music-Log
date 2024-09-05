package com.sooj.daily_music_log.domain

import com.sooj.daily_music_log.domain.api_model.Album
import com.sooj.daily_music_log.domain.api_model.Track

interface TrackRepository {

    suspend fun getMusic_impl(track : String) : List<Track>

    suspend fun getPoster_impl(track: String, artist : String) : Album?

    suspend fun saveSelected_impl()

    suspend fun getAllTracks_impl()
}