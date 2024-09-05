package com.sooj.daily_music_log.domain.api_model

import com.google.gson.annotations.SerializedName

data class SearchModel_dc(
    val results: Results?
)


data class Results(
    @SerializedName("opensearch:Query") val query: OpenSearchQuery?,
    @SerializedName("opensearch:totalResults") val totalResults: String?,
    @SerializedName("opensearch:startIndex") val startIndex: String?,
    @SerializedName("opensearch:itemsPerPage") val itemsPerPage: String?,
    val trackmatches: Trackmatches?
)

data class OpenSearchQuery(
    @SerializedName("#text") val text: String?,
    val role: String?,
    val searchTerms: String?,
    val startPage: String?
)

data class Trackmatches(
    val track: List<Track>?
)

data class Track(
    val name: String?,
    val artist: String?,
    val url: String?,
    val streamable: String?,
    val listeners: String?,
    val image: List<Image2>? // 이미지가 리스트로 반환
)

data class Image2(
    @SerializedName("#text") val url: String?,
    val size: String?,
)