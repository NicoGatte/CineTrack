package com.cinetrack.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00140\u0013J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00140\u0013J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/cinetrack/app/data/repository/SearchHistoryRepository;", "", "searchHistoryDao", "Lcom/cinetrack/app/data/local/dao/SearchHistoryDao;", "favoriteDao", "Lcom/cinetrack/app/data/local/dao/FavoriteDao;", "(Lcom/cinetrack/app/data/local/dao/SearchHistoryDao;Lcom/cinetrack/app/data/local/dao/FavoriteDao;)V", "addFavorite", "", "entity", "Lcom/cinetrack/app/data/local/entity/FavoriteEntity;", "(Lcom/cinetrack/app/data/local/entity/FavoriteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addSearch", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearHistory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "getRecentSearches", "Lcom/cinetrack/app/data/local/entity/SearchHistoryEntity;", "isFavorite", "", "movieId", "", "removeFavorite", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SearchHistoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.local.dao.SearchHistoryDao searchHistoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.cinetrack.app.data.local.dao.FavoriteDao favoriteDao = null;
    
    public SearchHistoryRepository(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.dao.SearchHistoryDao searchHistoryDao, @org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.dao.FavoriteDao favoriteDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.SearchHistoryEntity>> getRecentSearches() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.cinetrack.app.data.local.entity.FavoriteEntity>> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull()
    com.cinetrack.app.data.local.entity.FavoriteEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeFavorite(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isFavorite(int movieId) {
        return null;
    }
}