package com.cinetrack.app.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001Jf\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\u000e\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0012J,\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\b2\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0016\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u0019\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0012J,\u0010\u001f\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\u0019\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ,\u0010 \u001a\u00020\u00032\b\b\u0001\u0010!\u001a\u00020\u00052\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\"\u00a8\u0006#"}, d2 = {"Lcom/cinetrack/app/data/api/TmdbApiService;", "", "discoverMovies", "Lcom/cinetrack/app/data/api/dto/PaginatedResponse;", "language", "", "sortBy", "page", "", "withGenres", "year", "minRating", "", "maxRuntime", "minVoteCount", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGenres", "Lcom/cinetrack/app/data/api/dto/GenreListResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetail", "Lcom/cinetrack/app/data/api/dto/MovieDetailDto;", "movieId", "appendToResponse", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNowPlaying", "region", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopular", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopRated", "getTrending", "getUpcoming", "searchMovies", "query", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface TmdbApiService {
    
    @retrofit2.http.GET(value = "search/movie")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchMovies(@retrofit2.http.Query(value = "query")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.PaginatedResponse> $completion);
    
    @retrofit2.http.GET(value = "trending/movie/day")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTrending(@retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.PaginatedResponse> $completion);
    
    @retrofit2.http.GET(value = "movie/popular")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPopular(@retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.PaginatedResponse> $completion);
    
    @retrofit2.http.GET(value = "movie/now_playing")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNowPlaying(@retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "region")
    @org.jetbrains.annotations.NotNull()
    java.lang.String region, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.PaginatedResponse> $completion);
    
    @retrofit2.http.GET(value = "movie/upcoming")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUpcoming(@retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "region")
    @org.jetbrains.annotations.NotNull()
    java.lang.String region, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.PaginatedResponse> $completion);
    
    @retrofit2.http.GET(value = "movie/top_rated")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopRated(@retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.PaginatedResponse> $completion);
    
    @retrofit2.http.GET(value = "movie/{movie_id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMovieDetail(@retrofit2.http.Path(value = "movie_id")
    int movieId, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "append_to_response")
    @org.jetbrains.annotations.NotNull()
    java.lang.String appendToResponse, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.MovieDetailDto> $completion);
    
    @retrofit2.http.GET(value = "genre/movie/list")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGenres(@retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.GenreListResponse> $completion);
    
    @retrofit2.http.GET(value = "discover/movie")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object discoverMovies(@retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "sort_by")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sortBy, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "with_genres")
    @org.jetbrains.annotations.Nullable()
    java.lang.String withGenres, @retrofit2.http.Query(value = "primary_release_year")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer year, @retrofit2.http.Query(value = "vote_average.gte")
    @org.jetbrains.annotations.Nullable()
    java.lang.Float minRating, @retrofit2.http.Query(value = "with_runtime.lte")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxRuntime, @retrofit2.http.Query(value = "vote_count.gte")
    int minVoteCount, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.cinetrack.app.data.api.dto.PaginatedResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}