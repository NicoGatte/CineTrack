package com.cinetrack.app.data.api.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreDto(val id: Int, val name: String)

@JsonClass(generateAdapter = true)
data class GenreListResponse(val genres: List<GenreDto>)
