package com.cinetrack.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/cinetrack/app/data/repository/WatchlistRepository;", "", "dao", "Lcom/cinetrack/app/data/local/dao/WatchlistDao;", "(Lcom/cinetrack/app/data/local/dao/WatchlistDao;)V", "addToWatchlist", "", "entity", "Lcom/cinetrack/app/data/local/entity/WatchlistEntity;", "(Lcom/cinetrack/app/data/local/entity/WatchlistEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllItems", "Lkotlinx/coroutines/flow/Flow;", "", "getUnwatchedItems", "getWatchedItems", "isInWatchlist", "", "movieId", "", "removeFromWatchlist", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleWatched", "isWatched", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WatchlistRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.local.dao.WatchlistDao dao = null;
    
    public WatchlistRepository(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.dao.WatchlistDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.WatchlistEntity>> getAllItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.WatchlistEntity>> getWatchedItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.WatchlistEntity>> getUnwatchedItems() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addToWatchlist(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.entity.WatchlistEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeFromWatchlist(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object toggleWatched(int movieId, boolean isWatched, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isInWatchlist(int movieId) {
        return null;
    }
}