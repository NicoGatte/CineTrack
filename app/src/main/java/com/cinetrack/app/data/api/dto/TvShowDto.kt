package com.cinetrack.app.data.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TvShowDto(
    val id: Int,
    val name: String,
    @Json(name = "original_name") val originalName: String,
    val overview: String,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "first_air_date") val firstAirDate: String?,
    @Json(name = "vote_average") val voteAverage: Double,
    @Json(name = "vote_count") val voteCount: Int,
    val popularity: Double,
    @Json(name = "genre_ids") val genreIds: List<Int>?,
    @Json(name = "original_language") val originalLanguage: String
)

@JsonClass(generateAdapter = true)
data class TvPaginatedResponse(
    val page: Int,
    val results: List<TvShowDto>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)