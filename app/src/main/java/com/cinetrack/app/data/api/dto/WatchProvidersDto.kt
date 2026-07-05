package com.cinetrack.app.data.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WatchProvidersResponse(
    val id: Int?,
    val results: Map<String, WatchProviderCountryDto>?
)

@JsonClass(generateAdapter = true)
data class WatchProviderCountryDto(
    val link: String?,
    val flatrate: List<WatchProviderDto>?,
    val rent: List<WatchProviderDto>?,
    val buy: List<WatchProviderDto>?
)

@JsonClass(generateAdapter = true)
data class WatchProviderDto(
    @Json(name = "display_priority") val displayPriority: Int,
    @Json(name = "logo_path") val logoPath: String?,
    @Json(name = "provider_id") val providerId: Int,
    @Json(name = "provider_name") val providerName: String
)
