package com.cinetrack.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\fH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\b\u001a\u00020\tH\'J\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/cinetrack/app/data/local/dao/WatchlistDao;", "", "delete", "", "entity", "Lcom/cinetrack/app/data/local/entity/WatchlistEntity;", "(Lcom/cinetrack/app/data/local/entity/WatchlistEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByMovieId", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "getCount", "getUnwatched", "getWatched", "insert", "isInWatchlist", "", "toggleWatched", "isWatched", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface WatchlistDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.entity.WatchlistEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.entity.WatchlistEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM watchlist ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.WatchlistEntity>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM watchlist WHERE isWatched = 1 ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.WatchlistEntity>> getWatched();
    
    @androidx.room.Query(value = "SELECT * FROM watchlist WHERE isWatched = 0 ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.WatchlistEntity>> getUnwatched();
    
    @androidx.room.Query(value = "SELECT COUNT(*) > 0 FROM watchlist WHERE movieId = :movieId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isInWatchlist(int movieId);
    
    @androidx.room.Query(value = "UPDATE watchlist SET isWatched = :isWatched WHERE movieId = :movieId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object toggleWatched(int movieId, boolean isWatched, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM watchlist WHERE movieId = :movieId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByMovieId(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM watchlist")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getCount();
}