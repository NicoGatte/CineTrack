package com.cinetrack.app.domain.model

data class WatchProviderInfo(
    val link: String?,
    val streaming: List<WatchProvider>,
    val rent: List<WatchProvider>,
    val buy: List<WatchProvider>
) {
    val hasAnyProvider: Boolean get() = streaming.isNotEmpty() || rent.isNotEmpty() || buy.isNotEmpty()
}

data class WatchProvider(
    val providerId: Int,
    val providerName: String,
    val logoPath: String?
) {
    val logoUrl: String? get() = logoPath?.let { "https://image.tmdb.org/t/p/w92$it" }
}
