package com.cinetrack.app.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00c7\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0002\u0010\u001eJ\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\fH\u00c6\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00108J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u00c6\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013H\u00c6\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\t\u0010S\u001a\u00020\u0005H\u00c6\u0003J\t\u0010T\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010Y\u001a\u00020\fH\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\u00f6\u0001\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00132\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00c6\u0001\u00a2\u0006\u0002\u0010\\J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010`\u001a\u00020\u0003H\u00d6\u0001J\t\u0010a\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0013\u0010&\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b\'\u0010 R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0013\u00100\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b1\u0010 R\u0011\u00102\u001a\u0002038F\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010 R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010 R\u0013\u0010>\u001a\u0004\u0018\u00010\u00198F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010$R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\bG\u0010 \u00a8\u0006b"}, d2 = {"Lcom/cinetrack/app/domain/model/MovieDetail;", "", "id", "", "title", "", "originalTitle", "overview", "posterPath", "backdropPath", "releaseDate", "voteAverage", "", "voteCount", "popularity", "runtime", "tagline", "status", "genres", "", "Lcom/cinetrack/app/domain/model/Genre;", "cast", "Lcom/cinetrack/app/domain/model/CastMember;", "director", "videos", "Lcom/cinetrack/app/domain/model/Video;", "similarMovies", "Lcom/cinetrack/app/domain/model/Movie;", "watchProviders", "Lcom/cinetrack/app/domain/model/WatchProviderInfo;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIDLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/cinetrack/app/domain/model/WatchProviderInfo;)V", "getBackdropPath", "()Ljava/lang/String;", "backdropUrl", "getBackdropUrl", "getCast", "()Ljava/util/List;", "getDirector", "formattedRuntime", "getFormattedRuntime", "getGenres", "getId", "()I", "getOriginalTitle", "getOverview", "getPopularity", "()D", "getPosterPath", "posterUrl", "getPosterUrl", "ratingOutOf5", "", "getRatingOutOf5", "()F", "getReleaseDate", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSimilarMovies", "getStatus", "getTagline", "getTitle", "trailer", "getTrailer", "()Lcom/cinetrack/app/domain/model/Video;", "getVideos", "getVoteAverage", "getVoteCount", "getWatchProviders", "()Lcom/cinetrack/app/domain/model/WatchProviderInfo;", "year", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIDLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/cinetrack/app/domain/model/WatchProviderInfo;)Lcom/cinetrack/app/domain/model/MovieDetail;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class MovieDetail {
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
    private final java.lang.String tagline = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.cinetrack.app.domain.model.Genre> genres = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.cinetrack.app.domain.model.CastMember> cast = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String director = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.cinetrack.app.domain.model.Video> videos = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.cinetrack.app.domain.model.Movie> similarMovies = null;
    @org.jetbrains.annotations.Nullable()
    private final com.cinetrack.app.domain.model.WatchProviderInfo watchProviders = null;
    
    public MovieDetail(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String originalTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String overview, @org.jetbrains.annotations.Nullable()
    java.lang.String posterPath, @org.jetbrains.annotations.Nullable()
    java.lang.String backdropPath, @org.jetbrains.annotations.Nullable()
    java.lang.String releaseDate, double voteAverage, int voteCount, double popularity, @org.jetbrains.annotations.Nullable()
    java.lang.Integer runtime, @org.jetbrains.annotations.Nullable()
    java.lang.String tagline, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.CastMember> cast, @org.jetbrains.annotations.Nullable()
    java.lang.String director, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.Video> videos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.Movie> similarMovies, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.domain.model.WatchProviderInfo watchProviders) {
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
    public final java.lang.String getTagline() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.Genre> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.CastMember> getCast() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDirector() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.Video> getVideos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.Movie> getSimilarMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.domain.model.WatchProviderInfo getWatchProviders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getYear() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPosterUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBackdropUrl() {
        return null;
    }
    
    public final float getRatingOutOf5() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormattedRuntime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.domain.model.Video getTrailer() {
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
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.Genre> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.CastMember> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.Video> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.cinetrack.app.domain.model.Movie> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.cinetrack.app.domain.model.WatchProviderInfo component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
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
    public final com.cinetrack.app.domain.model.MovieDetail copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String originalTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String overview, @org.jetbrains.annotations.Nullable()
    java.lang.String posterPath, @org.jetbrains.annotations.Nullable()
    java.lang.String backdropPath, @org.jetbrains.annotations.Nullable()
    java.lang.String releaseDate, double voteAverage, int voteCount, double popularity, @org.jetbrains.annotations.Nullable()
    java.lang.Integer runtime, @org.jetbrains.annotations.Nullable()
    java.lang.String tagline, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.CastMember> cast, @org.jetbrains.annotations.Nullable()
    java.lang.String director, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.Video> videos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.cinetrack.app.domain.model.Movie> similarMovies, @org.jetbrains.annotations.Nullable()
    com.cinetrack.app.domain.model.WatchProviderInfo watchProviders) {
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