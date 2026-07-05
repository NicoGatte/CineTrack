package com.cinetrack.app.data.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditsDto(
    val cast: List<CastDto>,
    val crew: List<CrewDto>
)

@JsonClass(generateAdapter = true)
data class CastDto(
    val id: Int,
    val name: String,
    @Json(name = "original_name") val originalName: String,
    val character: String?,
    @Json(name = "profile_path") val profilePath: String?,
    val order: Int,
    val popularity: Double
)

@JsonClass(generateAdapter = true)
data class CrewDto(
    val id: Int,
    val name: String,
    @Json(name = "profile_path") val profilePath: String?,
    val department: String,
    val job: String
)
