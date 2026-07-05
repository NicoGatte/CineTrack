package com.cinetrack.app.domain.model

data class FilterOptions(
    val genreId: Int? = null,
    val year: Int? = null,
    val minRating: Float = 0f,
    val maxRuntime: Int? = null,
    val sortBy: SortOption = SortOption.POPULARITY_DESC
)

enum class SortOption(val apiValue: String, val displayName: String) {
    POPULARITY_DESC("popularity.desc", "Più Popolari"),
    VOTE_AVERAGE_DESC("vote_average.desc", "Miglior Voto"),
    RELEASE_DATE_DESC("release_date.desc", "Più Recenti"),
    TITLE_ASC("original_title.asc", "Titolo A-Z")
}
