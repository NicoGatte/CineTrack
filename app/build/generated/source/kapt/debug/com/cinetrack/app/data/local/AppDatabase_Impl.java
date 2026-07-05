package com.cinetrack.app.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.cinetrack.app.data.local.dao.FavoriteDao;
import com.cinetrack.app.data.local.dao.FavoriteDao_Impl;
import com.cinetrack.app.data.local.dao.SearchHistoryDao;
import com.cinetrack.app.data.local.dao.SearchHistoryDao_Impl;
import com.cinetrack.app.data.local.dao.WatchlistDao;
import com.cinetrack.app.data.local.dao.WatchlistDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile WatchlistDao _watchlistDao;

  private volatile SearchHistoryDao _searchHistoryDao;

  private volatile FavoriteDao _favoriteDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `watchlist` (`movieId` INTEGER NOT NULL, `title` TEXT NOT NULL, `posterPath` TEXT, `voteAverage` REAL NOT NULL, `releaseDate` TEXT, `overview` TEXT, `addedAt` INTEGER NOT NULL, `isWatched` INTEGER NOT NULL, PRIMARY KEY(`movieId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `search_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `query` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `favorites` (`movieId` INTEGER NOT NULL, `title` TEXT NOT NULL, `posterPath` TEXT, `voteAverage` REAL NOT NULL, `releaseDate` TEXT, `addedAt` INTEGER NOT NULL, PRIMARY KEY(`movieId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6b5fd131b8282e5c4ff48a6bb8c5aa35')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `watchlist`");
        db.execSQL("DROP TABLE IF EXISTS `search_history`");
        db.execSQL("DROP TABLE IF EXISTS `favorites`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsWatchlist = new HashMap<String, TableInfo.Column>(8);
        _columnsWatchlist.put("movieId", new TableInfo.Column("movieId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchlist.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchlist.put("posterPath", new TableInfo.Column("posterPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchlist.put("voteAverage", new TableInfo.Column("voteAverage", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchlist.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchlist.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchlist.put("addedAt", new TableInfo.Column("addedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWatchlist.put("isWatched", new TableInfo.Column("isWatched", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWatchlist = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWatchlist = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWatchlist = new TableInfo("watchlist", _columnsWatchlist, _foreignKeysWatchlist, _indicesWatchlist);
        final TableInfo _existingWatchlist = TableInfo.read(db, "watchlist");
        if (!_infoWatchlist.equals(_existingWatchlist)) {
          return new RoomOpenHelper.ValidationResult(false, "watchlist(com.cinetrack.app.data.local.entity.WatchlistEntity).\n"
                  + " Expected:\n" + _infoWatchlist + "\n"
                  + " Found:\n" + _existingWatchlist);
        }
        final HashMap<String, TableInfo.Column> _columnsSearchHistory = new HashMap<String, TableInfo.Column>(3);
        _columnsSearchHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSearchHistory.put("query", new TableInfo.Column("query", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSearchHistory.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSearchHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSearchHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSearchHistory = new TableInfo("search_history", _columnsSearchHistory, _foreignKeysSearchHistory, _indicesSearchHistory);
        final TableInfo _existingSearchHistory = TableInfo.read(db, "search_history");
        if (!_infoSearchHistory.equals(_existingSearchHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "search_history(com.cinetrack.app.data.local.entity.SearchHistoryEntity).\n"
                  + " Expected:\n" + _infoSearchHistory + "\n"
                  + " Found:\n" + _existingSearchHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsFavorites = new HashMap<String, TableInfo.Column>(6);
        _columnsFavorites.put("movieId", new TableInfo.Column("movieId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("posterPath", new TableInfo.Column("posterPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("voteAverage", new TableInfo.Column("voteAverage", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("addedAt", new TableInfo.Column("addedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavorites = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavorites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavorites = new TableInfo("favorites", _columnsFavorites, _foreignKeysFavorites, _indicesFavorites);
        final TableInfo _existingFavorites = TableInfo.read(db, "favorites");
        if (!_infoFavorites.equals(_existingFavorites)) {
          return new RoomOpenHelper.ValidationResult(false, "favorites(com.cinetrack.app.data.local.entity.FavoriteEntity).\n"
                  + " Expected:\n" + _infoFavorites + "\n"
                  + " Found:\n" + _existingFavorites);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "6b5fd131b8282e5c4ff48a6bb8c5aa35", "45d2309d10849bc2a557c39738cca730");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "watchlist","search_history","favorites");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `watchlist`");
      _db.execSQL("DELETE FROM `search_history`");
      _db.execSQL("DELETE FROM `favorites`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WatchlistDao.class, WatchlistDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SearchHistoryDao.class, SearchHistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FavoriteDao.class, FavoriteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public WatchlistDao watchlistDao() {
    if (_watchlistDao != null) {
      return _watchlistDao;
    } else {
      synchronized(this) {
        if(_watchlistDao == null) {
          _watchlistDao = new WatchlistDao_Impl(this);
        }
        return _watchlistDao;
      }
    }
  }

  @Override
  public SearchHistoryDao searchHistoryDao() {
    if (_searchHistoryDao != null) {
      return _searchHistoryDao;
    } else {
      synchronized(this) {
        if(_searchHistoryDao == null) {
          _searchHistoryDao = new SearchHistoryDao_Impl(this);
        }
        return _searchHistoryDao;
      }
    }
  }

  @Override
  public FavoriteDao favoriteDao() {
    if (_favoriteDao != null) {
      return _favoriteDao;
    } else {
      synchronized(this) {
        if(_favoriteDao == null) {
          _favoriteDao = new FavoriteDao_Impl(this);
        }
        return _favoriteDao;
      }
    }
  }
}
