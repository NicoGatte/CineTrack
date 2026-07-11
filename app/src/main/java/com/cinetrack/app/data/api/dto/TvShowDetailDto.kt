package com.cinetrack.app.data.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TvShowDetailDto(
    val id: Int,
    val name: String,
    @Json(name = "original_name") val originalName: String,
    val overview: String?,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "backdrop_path") val backdropPath: String?,
    @Json(name = "first_air_date") val firstAirDate: String?,
    @Json(name = "vote_average") val voteAverage: Double,
    @Json(name = "vote_count") val voteCount: Int,
    val popularity: Double,
    @Json(name = "number_of_seasons") val numberOfSeasons: Int?,
    @Json(name = "number_of_episodes") val numberOfEpisodes: Int?,
    val status: String?,
    val tagline: String?,
    val genres: List<GenreDto>?,
    val credits: CreditsDto?,
    val videos: VideosDto?,
    val similar: TvPaginatedResponse?,
    @Json(name = "watch/providers") val watchProviders: WatchProvidersResponse?
)