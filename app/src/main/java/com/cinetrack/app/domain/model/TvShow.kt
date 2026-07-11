package com.cinetrack.app.domain.model

data class TvShow(
    val id: Int,
    val name: String,
    val originalName: String,
    val overview: String,
    val posterPath: String?,
    val backdropPath: String?,
    val firstAirDate: String?,
    val voteAverage: Double,
    val voteCount: Int,
    val popularity: Double,
    val genreIds: List<Int>
) {
    val year: String get() = firstAirDate?.take(4) ?: ""
    val posterUrl: String? get() = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" }
    val backdropUrl: String? get() = backdropPath?.let { "https://image.tmdb.org/t/p/w780$it" }
    val ratingOutOf5: Float get() = (voteAverage / 2).toFloat()
}