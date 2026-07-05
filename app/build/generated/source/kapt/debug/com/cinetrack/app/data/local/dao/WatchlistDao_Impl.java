package com.cinetrack.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cinetrack.app.data.local.entity.WatchlistEntity;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WatchlistDao_Impl implements WatchlistDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WatchlistEntity> __insertionAdapterOfWatchlistEntity;

  private final EntityDeletionOrUpdateAdapter<WatchlistEntity> __deletionAdapterOfWatchlistEntity;

  private final SharedSQLiteStatement __preparedStmtOfToggleWatched;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByMovieId;

  public WatchlistDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWatchlistEntity = new EntityInsertionAdapter<WatchlistEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `watchlist` (`movieId`,`title`,`posterPath`,`voteAverage`,`releaseDate`,`overview`,`addedAt`,`isWatched`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WatchlistEntity entity) {
        statement.bindLong(1, entity.getMovieId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getPosterPath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPosterPath());
        }
        statement.bindDouble(4, entity.getVoteAverage());
        if (entity.getReleaseDate() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getReleaseDate());
        }
        if (entity.getOverview() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getOverview());
        }
        statement.bindLong(7, entity.getAddedAt());
        final int _tmp = entity.isWatched() ? 1 : 0;
        statement.bindLong(8, _tmp);
      }
    };
    this.__deletionAdapterOfWatchlistEntity = new EntityDeletionOrUpdateAdapter<WatchlistEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `watchlist` WHERE `movieId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WatchlistEntity entity) {
        statement.bindLong(1, entity.getMovieId());
      }
    };
    this.__preparedStmtOfToggleWatched = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE watchlist SET isWatched = ? WHERE movieId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByMovieId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM watchlist WHERE movieId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final WatchlistEntity entity, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWatchlistEntity.insert(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final WatchlistEntity entity, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWatchlistEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object toggleWatched(final int movieId, final boolean isWatched,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfToggleWatched.acquire();
        int _argIndex = 1;
        final int _tmp = isWatched ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, movieId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfToggleWatched.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteByMovieId(final int movieId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByMovieId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, movieId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteByMovieId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<WatchlistEntity>> getAll() {
    final String _sql = "SELECT * FROM watchlist ORDER BY addedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"watchlist"}, new Callable<List<WatchlistEntity>>() {
      @Override
      @NonNull
      public List<WatchlistEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMovieId = CursorUtil.getColumnIndexOrThrow(_cursor, "movieId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "posterPath");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfAddedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "addedAt");
          final int _cursorIndexOfIsWatched = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatched");
          final List<WatchlistEntity> _result = new ArrayList<WatchlistEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WatchlistEntity _item;
            final int _tmpMovieId;
            _tmpMovieId = _cursor.getInt(_cursorIndexOfMovieId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpPosterPath;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPosterPath = null;
            } else {
              _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final double _tmpVoteAverage;
            _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final String _tmpReleaseDate;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpReleaseDate = null;
            } else {
              _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final long _tmpAddedAt;
            _tmpAddedAt = _cursor.getLong(_cursorIndexOfAddedAt);
            final boolean _tmpIsWatched;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsWatched);
            _tmpIsWatched = _tmp != 0;
            _item = new WatchlistEntity(_tmpMovieId,_tmpTitle,_tmpPosterPath,_tmpVoteAverage,_tmpReleaseDate,_tmpOverview,_tmpAddedAt,_tmpIsWatched);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WatchlistEntity>> getWatched() {
    final String _sql = "SELECT * FROM watchlist WHERE isWatched = 1 ORDER BY addedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"watchlist"}, new Callable<List<WatchlistEntity>>() {
      @Override
      @NonNull
      public List<WatchlistEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMovieId = CursorUtil.getColumnIndexOrThrow(_cursor, "movieId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "posterPath");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfAddedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "addedAt");
          final int _cursorIndexOfIsWatched = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatched");
          final List<WatchlistEntity> _result = new ArrayList<WatchlistEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WatchlistEntity _item;
            final int _tmpMovieId;
            _tmpMovieId = _cursor.getInt(_cursorIndexOfMovieId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpPosterPath;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPosterPath = null;
            } else {
              _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final double _tmpVoteAverage;
            _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final String _tmpReleaseDate;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpReleaseDate = null;
            } else {
              _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final long _tmpAddedAt;
            _tmpAddedAt = _cursor.getLong(_cursorIndexOfAddedAt);
            final boolean _tmpIsWatched;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsWatched);
            _tmpIsWatched = _tmp != 0;
            _item = new WatchlistEntity(_tmpMovieId,_tmpTitle,_tmpPosterPath,_tmpVoteAverage,_tmpReleaseDate,_tmpOverview,_tmpAddedAt,_tmpIsWatched);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WatchlistEntity>> getUnwatched() {
    final String _sql = "SELECT * FROM watchlist WHERE isWatched = 0 ORDER BY addedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"watchlist"}, new Callable<List<WatchlistEntity>>() {
      @Override
      @NonNull
      public List<WatchlistEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMovieId = CursorUtil.getColumnIndexOrThrow(_cursor, "movieId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfPosterPath = CursorUtil.getColumnIndexOrThrow(_cursor, "posterPath");
          final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfAddedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "addedAt");
          final int _cursorIndexOfIsWatched = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatched");
          final List<WatchlistEntity> _result = new ArrayList<WatchlistEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WatchlistEntity _item;
            final int _tmpMovieId;
            _tmpMovieId = _cursor.getInt(_cursorIndexOfMovieId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpPosterPath;
            if (_cursor.isNull(_cursorIndexOfPosterPath)) {
              _tmpPosterPath = null;
            } else {
              _tmpPosterPath = _cursor.getString(_cursorIndexOfPosterPath);
            }
            final double _tmpVoteAverage;
            _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final String _tmpReleaseDate;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpReleaseDate = null;
            } else {
              _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpOverview;
            if (_cursor.isNull(_cursorIndexOfOverview)) {
              _tmpOverview = null;
            } else {
              _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            }
            final long _tmpAddedAt;
            _tmpAddedAt = _cursor.getLong(_cursorIndexOfAddedAt);
            final boolean _tmpIsWatched;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsWatched);
            _tmpIsWatched = _tmp != 0;
            _item = new WatchlistEntity(_tmpMovieId,_tmpTitle,_tmpPosterPath,_tmpVoteAverage,_tmpReleaseDate,_tmpOverview,_tmpAddedAt,_tmpIsWatched);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Boolean> isInWatchlist(final int movieId) {
    final String _sql = "SELECT COUNT(*) > 0 FROM watchlist WHERE movieId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, movieId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"watchlist"}, new Callable<Boolean>() {
      @Override
      @NonNull
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp == null ? null : _tmp != 0;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getCount() {
    final String _sql = "SELECT COUNT(*) FROM watchlist";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"watchlist"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
