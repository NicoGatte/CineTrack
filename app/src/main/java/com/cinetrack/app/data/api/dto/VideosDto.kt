package com.cinetrack.app.data.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideosDto(
    @Json(name = "id") val id: Int?,  // CAMBIA: Int -> Int?
    @Json(name = "results") val results: List<VideoDto>
)
@JsonClass(generateAdapter = true)
data class VideoDto(
    @Json(name = "id") val id: String?,  // CAMBIA: String -> String?
    @Json(name = "iso_639_1") val iso6391: String?,
    @Json(name = "iso_3166_1") val iso31661: String?,
    @Json(name = "key") val key: String,
    @Json(name = "name") val name: String,
    @Json(name = "site") val site: String,
    @Json(name = "size") val size: Int?,
    @Json(name = "type") val type: String,
    @Json(name = "official") val official: Boolean = false
)