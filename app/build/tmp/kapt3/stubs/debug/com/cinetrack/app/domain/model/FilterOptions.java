package com.cinetrack.app.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\tH\u00c6\u0003JF\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/cinetrack/app/domain/model/FilterOptions;", "", "genreId", "", "year", "minRating", "", "maxRuntime", "sortBy", "Lcom/cinetrack/app/domain/model/SortOption;", "(Ljava/lang/Integer;Ljava/lang/Integer;FLjava/lang/Integer;Lcom/cinetrack/app/domain/model/SortOption;)V", "getGenreId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxRuntime", "getMinRating", "()F", "getSortBy", "()Lcom/cinetrack/app/domain/model/SortOption;", "getYear", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;FLjava/lang/Integer;Lcom/cinetrack/app/domain/model/SortOption;)Lcom/cinetrack/app/domain/model/FilterOptions;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class FilterOptions {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer genreId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer year = null;
    private final float minRating = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer maxRuntime = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.domain.model.SortOption sortBy = null;
    
    public FilterOptions(@org.jetbrains.annotations.Nullable()
    java.lang.Integer genreId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer year, float minRating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxRuntime, @org.jetbrains.annotations.NotNull()
    com.cinetrack.app.domain.model.SortOption sortBy) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGenreId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getYear() {
        return null;
    }
    
    public final float getMinRating() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMaxRuntime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.domain.model.SortOption getSortBy() {
        return null;
    }
    
    public FilterOptions() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component2() {
        return null;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.domain.model.SortOption component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.domain.model.FilterOptions copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer genreId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer year, float minRating, @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxRuntime, @org.jetbrains.annotations.NotNull()
    com.cinetrack.app.domain.model.SortOption sortBy) {
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