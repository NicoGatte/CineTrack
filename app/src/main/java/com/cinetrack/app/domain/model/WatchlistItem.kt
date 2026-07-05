package com.cinetrack.app.domain.model

data class WatchlistItem(
    val movieId: Int,
    val title: String,
    val posterPath: String?,
    val voteAverage: Double,
    val releaseDate: String?,
    val overview: String?,
    val addedAt: Long,
    val isWatched: Boolean
) {
    val posterUrl: String? get() = posterPath?.let { "https://image.tmdb.org/t/p/w342$it" }
    val year: String get() = releaseDate?.take(4) ?: ""
    val ratingOutOf5: Float get() = (voteAverage / 2).toFloat()
}
