package com.cinetrack.app.data.api.dto;

@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u00eb\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010!\u00a2\u0006\u0002\u0010\"J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\fH\u00c6\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00108J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010I\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u001fH\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010!H\u00c6\u0003J\t\u0010T\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010Y\u001a\u00020\fH\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\u0090\u0002\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010!H\u00c6\u0001\u00a2\u0006\u0002\u0010\\J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010`\u001a\u00020\u0003H\u00d6\u0001J\t\u0010a\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b%\u0010&R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b6\u0010&R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010$R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0013\u0010 \u001a\u0004\u0018\u00010!\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010D\u00a8\u0006b"}, d2 = {"Lcom/cinetrack/app/data/api/dto/MovieDetailDto;", "", "id", "", "title", "", "originalTitle", "overview", "posterPath", "backdropPath", "releaseDate", "voteAverage", "", "voteCount", "popularity", "runtime", "budget", "", "revenue", "status", "tagline", "homepage", "imdbId", "genres", "", "Lcom/cinetrack/app/data/api/dto/GenreDto;", "credits", "Lcom/cinetrack/app/data/api/dto/CreditsDto;", "videos", "Lcom/cinetrack/app/data/api/dto/VideosDto;", "similar", "Lcom/cinetrack/app/data/api/dto/PaginatedResponse;", "watchProviders", "Lcom/cinetrack/app/data/api/dto/WatchProvidersResponse;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIDLjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/cinetrack/app/data/api/dto/CreditsDto;Lcom/cinetrack/app/data/api/dto/VideosDto;Lcom/cinetrack/app/data/api/dto/PaginatedResponse;Lcom/cinetrack/app/data/api/dto/WatchProvidersResponse;)V", "getBackdropPath", "()Ljava/lang/String;", "getBudget", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCredits", "()Lcom/cinetrack/app/data/api/dto/CreditsDto;", "getGenres", "()Ljava/util/List;", "getHomepage", "getId", "()I", "getImdbId", "getOriginalTitle", "getOverview", "getPopularity", "()D", "getPosterPath", "getReleaseDate", "getRevenue", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSimilar", "()Lcom/cinetrack/app/data/api/dto/PaginatedResponse;", "getStatus", "getTagline", "getTitle", "getVideos", "()Lcom/cinetrack/app/data/api/dto/VideosDto;", "getVoteAverage", "getVoteCount", "getWatchProviders", "()Lcom/cinetrack/app/data/api/dto/WatchProvidersResponse;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIDLjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/cinetrack/app/data/api/dto/CreditsDto;Lcom/cinetrack/app/data/api/dto/VideosDto;Lcom/cinetrack/app/data/api/dto/PaginatedResponse;Lcom/cinetrack/app/data/api/dto/WatchProvidersResponse;)Lcom/cinetrack/app/data/api/dto/MovieDetailDto;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class MovieDetailDto {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String originalTitle = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String overview = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String posterPath = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String backdropPath = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String releaseDate = null;
    private final double voteAverage = 0.0;
    private final int voteCount = 0;
    private final double popularity = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer runtime = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long budget = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long revenue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String tagline = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String homepage = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imdbId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.cinetrack.app.data.api.dto.GenreDto> genres = null;
    @org.jetbrains.annotations.Nullable()
    private final com.cinetrack.app.data.api.dto.CreditsDto credits = null;
    @org.jetbrains.annotations.Nullable()
    private final com.cinetrack.app.data.api.dto.VideosDto videos = null;
    @org.jetbrains.annotations.Nullable()
    private final com.cinetrack.app.data.api.dto.PaginatedResponse similar = null;
    @org.jetbrains.annotations.Nullable()
    private final com.cinetrack.app.data.api.dto.WatchProvidersResponse watchProviders = null;
    
    public MovieDetailDto(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @com.squareup.moshi.Json(name = "original_title")
    @org.jetbrains.annotations.NotNull()
    java.lang.String originalTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String overview, @com.squareup.moshi.Json(name = "poster_path")
    @org.jetbrains.annotations.Nullable()
    java.lang.String posterPath, @com.squareup.moshi.Json(name = "backdrop_path")
    @org.jetbrains.annotations.Nullable()
    java.lang.String backdropPath, @com.squareup.moshi.Json(name = "release_date")
    @org.jetbrains.annotations.Nullable()
    java.lang.String releaseDate, @com.squareup.moshi.Json(name = "vote_average")
    double voteAverage, @com.squareup.moshi.Json(name = "vote_count")
    int voteCount, double popularity, @org.jetbrains.annotations.Nullable()
    java.lang.Integer runtime, @org.jetbrains.annotations.Nullable()
    java.lang.Long budget, @org.jetbrains.annotations.Nullable()
    java.lang.Long revenue, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String tagline, @org.jetbrains.annotations.Nullable()
    java.lang.String homepage, @com.squareup.moshi.Json(name = "imdb_id")
    @org.jetbrains.annotations.Nullable()
    java.lang.String imdbId, @org.jetbrains.annotations.Nullable()
    java.util.List<com.cinetrack.app.data.api.dto.GenreDto> genres, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.CreditsDto credits, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.VideosDto videos, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.PaginatedResponse similar, @com.squareup.moshi.Json(name = "watch/providers")
    @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.WatchProvidersResponse watchProviders) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOriginalTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOverview() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPosterPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBackdropPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReleaseDate() {
        return null;
    }
    
    public final double getVoteAverage() {
        return 0.0;
    }
    
    public final int getVoteCount() {
        return 0;
    }
    
    public final double getPopularity() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRuntime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getBudget() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getRevenue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTagline() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHomepage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImdbId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.cinetrack.app.data.api.dto.GenreDto> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.CreditsDto getCredits() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.VideosDto getVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.PaginatedResponse getSimilar() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.WatchProvidersResponse getWatchProviders() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.cinetrack.app.data.api.dto.GenreDto> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.CreditsDto component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.VideosDto component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.PaginatedResponse component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.data.api.dto.WatchProvidersResponse component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.data.api.dto.MovieDetailDto copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @com.squareup.moshi.Json(name = "original_title")
    @org.jetbrains.annotations.NotNull()
    java.lang.String originalTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String overview, @com.squareup.moshi.Json(name = "poster_path")
    @org.jetbrains.annotations.Nullable()
    java.lang.String posterPath, @com.squareup.moshi.Json(name = "backdrop_path")
    @org.jetbrains.annotations.Nullable()
    java.lang.String backdropPath, @com.squareup.moshi.Json(name = "release_date")
    @org.jetbrains.annotations.Nullable()
    java.lang.String releaseDate, @com.squareup.moshi.Json(name = "vote_average")
    double voteAverage, @com.squareup.moshi.Json(name = "vote_count")
    int voteCount, double popularity, @org.jetbrains.annotations.Nullable()
    java.lang.Integer runtime, @org.jetbrains.annotations.Nullable()
    java.lang.Long budget, @org.jetbrains.annotations.Nullable()
    java.lang.Long revenue, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String tagline, @org.jetbrains.annotations.Nullable()
    java.lang.String homepage, @com.squareup.moshi.Json(name = "imdb_id")
    @org.jetbrains.annotations.Nullable()
    java.lang.String imdbId, @org.jetbrains.annotations.Nullable()
    java.util.List<com.cinetrack.app.data.api.dto.GenreDto> genres, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.CreditsDto credits, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.VideosDto videos, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.PaginatedResponse similar, @com.squareup.moshi.Json(name = "watch/providers")
    @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.data.api.dto.WatchProvidersResponse watchProviders) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}