package com.cinetrack.app.domain.model

data class TvShowDetail(
    val id: Int,
    val name: String,
    val originalName: String,
    val overview: String?,
    val posterPath: String?,
    val backdropPath: String?,
    val firstAirDate: String?,
    val voteAverage: Double,
    val voteCount: Int,
    val popularity: Double,
    val numberOfSeasons: Int?,
    val numberOfEpisodes: Int?,
    val tagline: String?,
    val status: String?,
    val genres: List<Genre>,
    val cast: List<CastMember>,
    val videos: List<Video>,
    val similarShows: List<TvShow>,
    val watchProviders: WatchProviderInfo?
) {
    val year: String get() = firstAirDate?.take(4) ?: ""
    val posterUrl: String? get() = posterPath?.let { "https://image.tmdb.org/t/p/w780$it" }
    val backdropUrl: String? get() = backdropPath?.let { "https://image.tmdb.org/t/p/w1280$it" }
    val ratingOutOf5: Float get() = (voteAverage / 2).toFloat()
    val formattedSeasons: String? get() = numberOfSeasons?.let { if (it == 1) "1 stagione" else "$it stagioni" }
    val trailer: Video? get() = videos.firstOrNull { it.type == "Trailer" && it.site == "YouTube" }
        ?: videos.firstOrNull { it.site == "YouTube" }
}