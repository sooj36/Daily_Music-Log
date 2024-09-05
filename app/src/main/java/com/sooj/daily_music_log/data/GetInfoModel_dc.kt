package com.sooj.daily_music_log.data

import com.google.gson.annotations.SerializedName

/**  음악 정보 API  */

data class GetInfoModel_dc(
    val track: Track2
)

data class Track2(
    val name: String,
    val mbid: String?,
    val url: String,
    val duration: String?,
    val streamable: Streamable,
    val listeners: String,
    val playcount: String,
    val artist: Artist,
    val album: Album,
)

data class Streamable(
    @SerializedName("#text") val text : String,
    val fulltrack: String,
)

data class Artist(
    val name : String,
    val mbid: String?,
    val url: String
)

data class Album(
    val artist : String,
    val title : String,
    val mbid : String?,
    val url: String,
    val image: List<Image>
)


data class Image(
    @SerializedName("#text") val url: String,
    val size : String
)


