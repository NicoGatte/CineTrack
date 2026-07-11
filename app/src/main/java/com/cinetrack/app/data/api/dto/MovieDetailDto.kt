package com.cinetrack.app.data.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailDto(
    val id: Int,
    val title: String,
    @Json(name = "original_title") val originalTitle: String,
    val overview: String?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "vote_average") val voteAverage: Double,
    @Json(name = "vote_count") val voteCount: Int,
    val popularity: Double,
    val runtime: Int?,
    val budget: Long?,
    val revenue: Long?,
    val status: String?,
    val tagline: String?,
    val homepage: String?,
    @Json(name = "imdb_id") val imdbId: String?,
    val genres: List<GenreDto>?,
    val credits: CreditsDto?,
    val videos: VideosDto?,
    val similar: PaginatedResponse?,
    @Json(name = "watch/providers") val watchProviders: WatchProvidersResponse?
)