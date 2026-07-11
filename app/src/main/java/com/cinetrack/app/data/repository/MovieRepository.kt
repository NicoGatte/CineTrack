package com.cinetrack.app.data.repository

import com.cinetrack.app.data.api.TmdbApiService
import com.cinetrack.app.data.api.dto.GenreDto
import com.cinetrack.app.data.api.dto.MovieDetailDto
import com.cinetrack.app.data.api.dto.MovieDto
import com.cinetrack.app.data.api.dto.PaginatedResponse
import com.cinetrack.app.data.api.dto.VideoDto

class MovieRepository(private val apiService: TmdbApiService) {

    // Change this line in MovieRepository.kt
    suspend fun searchMovies(query: String, page: Int = 1): Result<PaginatedResponse> = runCatching {
        apiService.searchMovies(query = query, page = page)
    }

    suspend fun getTrending(): Result<List<MovieDto>> = runCatching {
        apiService.getTrending().results
    }

    suspend fun getPopular(page: Int = 1): Result<PaginatedResponse> = runCatching {
        apiService.getPopular(page = page)
    }

    suspend fun getNowPlaying(page: Int = 1): Result<PaginatedResponse> = runCatching {
        apiService.getNowPlaying(page = page)
    }

    suspend fun getUpcoming(page: Int = 1): Result<PaginatedResponse> = runCatching {
        apiService.getUpcoming(page = page)
    }

    suspend fun getTopRated(page: Int = 1): Result<PaginatedResponse> = runCatching {
        apiService.getTopRated(page = page)
    }

    suspend fun getMovieDetail(movieId: Int): Result<MovieDetailDto> = runCatching {
        apiService.getMovieDetail(movieId)
    }

    suspend fun getGenres(): Result<List<GenreDto>> = runCatching {
        apiService.getGenres().genres
    }
     suspend fun getMovieVideos(movieId: Int): Result<List<VideoDto>> = runCatching {
        apiService.getMovieVideos(movieId).results
    }

    suspend fun discoverMovies(
        sortBy: String,
        page: Int,
        withGenres: String?,
        year: Int?,
        minRating: Float?,
        maxRuntime: Int?
    ): Result<PaginatedResponse> = runCatching {
        apiService.discoverMovies(
            sortBy = sortBy,
            page = page,
            withGenres = withGenres,
            year = year,
            minRating = minRating,
            maxRuntime = maxRuntime
        )
    }
}
