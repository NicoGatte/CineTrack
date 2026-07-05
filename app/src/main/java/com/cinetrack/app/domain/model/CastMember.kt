package com.cinetrack.app.domain.model

data class CastMember(
    val id: Int,
    val name: String,
    val character: String?,
    val profilePath: String?,
    val order: Int
) {
    val profileUrl: String? get() = profilePath?.let { "https://image.tmdb.org/t/p/w185$it" }
}
