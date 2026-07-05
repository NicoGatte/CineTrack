package com.cinetrack.app.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\fH\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\fH\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\u0083\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u00c6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020\u0003H\u00d6\u0001J\t\u0010;\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0011\u0010!\u001a\u00020\"8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010)\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u0013\u00a8\u0006<"}, d2 = {"Lcom/cinetrack/app/domain/model/Movie;", "", "id", "", "title", "", "originalTitle", "overview", "posterPath", "backdropPath", "releaseDate", "voteAverage", "", "voteCount", "popularity", "genreIds", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIDLjava/util/List;)V", "getBackdropPath", "()Ljava/lang/String;", "backdropUrl", "getBackdropUrl", "getGenreIds", "()Ljava/util/List;", "getId", "()I", "getOriginalTitle", "getOverview", "getPopularity", "()D", "getPosterPath", "posterUrl", "getPosterUrl", "ratingOutOf5", "", "getRatingOutOf5", "()F", "getReleaseDate", "getTitle", "getVoteAverage", "getVoteCount", "year", "getYear", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Movie {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String originalTitle = null;
    @org.jetbrains.annotations.NotNull()
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
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> genreIds = null;
    
    public Movie(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String originalTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String overview, @org.jetbrains.annotations.Nullable()
    java.lang.String posterPath, @org.jetbrains.annotations.Nullable()
    java.lang.String backdropPath, @org.jetbrains.annotations.Nullable()
    java.lang.String releaseDate, double voteAverage, int voteCount, double popularity, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> genreIds) {
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
    
    @org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getGenreIds() {
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
    
    public final int component1() {
        return 0;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> component11() {
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
    
    @org.jetbrains.annotations.NotNull()
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
    public final com.cinetrack.app.domain.model.Movie copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String originalTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String overview, @org.jetbrains.annotations.Nullable()
    java.lang.String posterPath, @org.jetbrains.annotations.Nullable()
    java.lang.String backdropPath, @org.jetbrains.annotations.Nullable()
    java.lang.String releaseDate, double voteAverage, int voteCount, double popularity, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> genreIds) {
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