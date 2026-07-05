package com.cinetrack.app.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/cinetrack/app/data/api/TmdbApiClient;", "", "()V", "API_KEY", "", "BASE_URL", "IMAGE_BASE_URL", "apiService", "Lcom/cinetrack/app/data/api/TmdbApiService;", "getApiService", "()Lcom/cinetrack/app/data/api/TmdbApiService;", "apiService$delegate", "Lkotlin/Lazy;", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "backdropUrl", "path", "size", "logoUrl", "posterUrl", "profileUrl", "app_debug"})
public final class TmdbApiClient {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY = "53eaf7037e2d966a857390cb0ea4df0c";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://api.themoviedb.org/3/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    private static final com.squareup.moshi.Moshi moshi = null;
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient okHttpClient = null;
    private static final retrofit2.Retrofit retrofit = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy apiService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.cinetrack.app.data.api.TmdbApiClient INSTANCE = null;
    
    private TmdbApiClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cinetrack.app.data.api.TmdbApiService getApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String posterUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String size) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String backdropUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String size) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String profileUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String size) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String logoUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String size) {
        return null;
    }
}