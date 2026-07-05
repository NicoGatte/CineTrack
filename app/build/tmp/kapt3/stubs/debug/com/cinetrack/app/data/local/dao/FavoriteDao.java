package com.cinetrack.app.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\b\u001a\u00020\tH\'\u00a8\u0006\u0011"}, d2 = {"Lcom/cinetrack/app/data/local/dao/FavoriteDao;", "", "delete", "", "entity", "Lcom/cinetrack/app/data/local/entity/FavoriteEntity;", "(Lcom/cinetrack/app/data/local/entity/FavoriteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByMovieId", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "insert", "isFavorite", "", "app_debug"})
@androidx.room.Dao()
public abstract interface FavoriteDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.entity.FavoriteEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.entity.FavoriteEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM favorites ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.FavoriteEntity>> getAll();
    
    @androidx.room.Query(value = "SELECT COUNT(*) > 0 FROM favorites WHERE movieId = :movieId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isFavorite(int movieId);
    
    @androidx.room.Query(value = "DELETE FROM favorites WHERE movieId = :movieId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByMovieId(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}