package com.cinetrack.app.data.repository

import com.cinetrack.app.data.api.TmdbApiService
import com.cinetrack.app.data.api.dto.TvPaginatedResponse
import com.cinetrack.app.data.api.dto.TvShowDetailDto
import com.cinetrack.app.data.api.dto.TvShowDto
import com.cinetrack.app.data.api.dto.VideoDto

class TvShowRepository(private val apiService: TmdbApiService) {
    suspend fun searchTvShows(query: String, page: Int = 1): Result<TvPaginatedResponse> = runCatching {
        apiService.searchTvShows(query = query, page = page)
    }

    suspend fun getTrendingTv(): Result<List<TvShowDto>> = runCatching {
        apiService.getTrendingTv().results
    }

    suspend fun getPopularTv(page: Int = 1): Result<TvPaginatedResponse> = runCatching {
        apiService.getPopularTv(page = page)
    }

    suspend fun getTopRatedTv(page: Int = 1): Result<TvPaginatedResponse> = runCatching {
        apiService.getTopRatedTv(page = page)
    }

    suspend fun getOnTheAirTv(page: Int = 1): Result<TvPaginatedResponse> = runCatching {
        apiService.getOnTheAirTv(page = page)
    }

    suspend fun getTvShowDetail(tvId: Int): Result<TvShowDetailDto> = runCatching {
        apiService.getTvShowDetail(tvId)
    }

    suspend fun getTvVideos(tvId: Int): Result<List<VideoDto>> = runCatching {
        apiService.getTvVideos(tvId).results
    }
}