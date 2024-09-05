package com.sooj.daily_music_log.data

import com.sooj.daily_music_log.BuildConfig
import com.sooj.daily_music_log.domain.api_model.GetInfoModel_dc
import com.sooj.daily_music_log.domain.api_model.SearchModel_dc
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService_endPoint {
    @GET("2.0/")
    suspend fun getTrackSearch(
        @Query("method") method: String = "track.search",
        @Query("track") track: String = "",
        @Query("api_key") apiKey :String = BuildConfig.LAST_FM_API_KEY,
        @Query("format") format: String = "json",
    ): Response<SearchModel_dc>

    @GET("2.0/")
    suspend fun getPostInfo(
        @Query("method") method: String = "track.getInfo",
        @Query("api_key") apiKey: String = BuildConfig.LAST_FM_API_KEY,
        @Query("artist") artist : String,
        @Query("track") track: String = "",
        @Query("format") format: String = "json"
    ) : Response<GetInfoModel_dc>
}