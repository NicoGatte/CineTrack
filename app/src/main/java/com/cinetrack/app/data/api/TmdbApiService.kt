package com.cinetrack.app.data.api

import com.cinetrack.app.data.api.dto.GenreListResponse
import com.cinetrack.app.data.api.dto.MovieDetailDto
import com.cinetrack.app.data.api.dto.MovieDto
import com.cinetrack.app.data.api.dto.PaginatedResponse
import com.cinetrack.app.data.api.dto.TvPaginatedResponse
import com.cinetrack.app.data.api.dto.TvShowDetailDto
import com.cinetrack.app.data.api.dto.VideosDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {

    companion object {
        const val API_KEY = "53eaf7037e2d966a857390cb0ea4df0c"
    }

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("search/tv")
    suspend fun searchTvShows(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): TvPaginatedResponse

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT",
        @Query("append_to_response") appendToResponse: String = "credits,videos,watch/providers"
    ): MovieDetailDto

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): GenreListResponse

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): VideosDto

    @GET("discover/movie")
    suspend fun discoverMovies(
        @Query("sort_by") sortBy: String,
        @Query("page") page: Int,
        @Query("with_genres") withGenres: String? = null,
        @Query("year") year: Int? = null,
        @Query("vote_average.gte") minRating: Float? = null,
        @Query("with_runtime.lte") maxRuntime: Int? = null,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("trending/movie/day")
    suspend fun getTrending(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): PaginatedResponse

    @GET("trending/tv/day")
    suspend fun getTrendingTv(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): TvPaginatedResponse

    @GET("tv/popular")
    suspend fun getPopularTv(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): TvPaginatedResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTv(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): TvPaginatedResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTv(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): TvPaginatedResponse

    @GET("tv/{tv_id}")
    suspend fun getTvShowDetail(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT",
        @Query("append_to_response") appendToResponse: String = "credits,videos,watch/providers"
    ): TvShowDetailDto

    @GET("tv/{tv_id}/videos")
    suspend fun getTvVideos(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "it-IT"
    ): VideosDto
}