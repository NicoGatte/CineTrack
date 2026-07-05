package com.cinetrack.app.data.api

import com.cinetrack.app.data.api.dto.GenreListResponse
import com.cinetrack.app.data.api.dto.MovieDetailDto
import com.cinetrack.app.data.api.dto.PaginatedResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("language") language: String = "it-IT",
        @Query("page") page: Int = 1
    ): PaginatedResponse

    @GET("trending/movie/day")
    suspend fun getTrending(
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("language") language: String = "it-IT",
        @Query("page") page: Int = 1
    ): PaginatedResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("language") language: String = "it-IT",
        @Query("page") page: Int = 1,
        @Query("region") region: String = "IT"
    ): PaginatedResponse

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("language") language: String = "it-IT",
        @Query("page") page: Int = 1,
        @Query("region") region: String = "IT"
    ): PaginatedResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("language") language: String = "it-IT",
        @Query("page") page: Int = 1
    ): PaginatedResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "it-IT",
        @Query("append_to_response") appendToResponse: String = "credits,videos,similar,watch/providers"
    ): MovieDetailDto

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("language") language: String = "it"
    ): GenreListResponse

    @GET("discover/movie")
    suspend fun discoverMovies(
        @Query("language") language: String = "it-IT",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("page") page: Int = 1,
        @Query("with_genres") withGenres: String? = null,
        @Query("primary_release_year") year: Int? = null,
        @Query("vote_average.gte") minRating: Float? = null,
        @Query("with_runtime.lte") maxRuntime: Int? = null,
        @Query("vote_count.gte") minVoteCount: Int = 100
    ): PaginatedResponse
}
