package com.cinetrack.app.domain.model

data class Video(
    val id: String,
    val name: String,
    val key: String,
    val site: String,
    val type: String,
    val official: Boolean
) {
    val youtubeUrl: String get() = "https://www.youtube.com/watch?v=$key"
    val youtubeEmbedUrl: String get() = "https://www.youtube.com/embed/$key"
    val thumbnailUrl: String get() = "https://img.youtube.com/vi/$key/hqdefault.jpg"
}
