package com.cinetrack.app.domain.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val originalTitle: String,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val releaseDate: String?,
    val voteAverage: Double,
    val voteCount: Int,
    val popularity: Double,
    val runtime: Int?,
    val tagline: String?,
    val status: String?,
    val genres: List<Genre>,
    val cast: List<CastMember>,
    val director: String?,
    val videos: List<Video>,
    val similarMovies: List<Movie>,
    val watchProviders: WatchProviderInfo?
) {
    val year: String get() = releaseDate?.take(4) ?: ""
    val posterUrl: String? get() = posterPath?.let { "https://image.tmdb.org/t/p/w780$it" }
    val backdropUrl: String? get() = backdropPath?.let { "https://image.tmdb.org/t/p/w1280$it" }
    val ratingOutOf5: Float get() = (voteAverage / 2).toFloat()
    val formattedRuntime: String? get() = runtime?.let { "${it / 60}h ${it % 60}min" }
    val trailer: Video? get() = videos.firstOrNull { it.type == "Trailer" && it.site == "YouTube" }
        ?: videos.firstOrNull { it.site == "YouTube" }
}
