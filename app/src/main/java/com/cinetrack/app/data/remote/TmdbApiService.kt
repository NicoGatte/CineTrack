package com.cinetrack.app.data.remote

import com.squareup.moshi.Json
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("53eaf7037e2d966a857390cb0ea4df0c") apiKey: String,
        @Query("query") query: String,
        @Query("page") page: Int = 1
    ): MovieSearchResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("53eaf7037e2d966a857390cb0ea4df0c") apiKey: String
    ): MovieDto
}

// Data models for the API response
data class MovieSearchResponse(
    val page: Int,
    val results: List<MovieDto>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int
)

data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @Json(name = "poster_path") val posterPath: String?,
    @Json(name = "release_date") val releaseDate: String?,
    @Json(name = "vote_average") val voteAverage: Double
)