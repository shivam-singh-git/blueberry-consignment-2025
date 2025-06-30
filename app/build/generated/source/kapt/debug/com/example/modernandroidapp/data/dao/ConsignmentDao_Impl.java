package com.example.modernandroidapp.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.modernandroidapp.data.entity.ConsignmentEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
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
public final class ConsignmentDao_Impl implements ConsignmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ConsignmentEntity> __insertionAdapterOfConsignmentEntity;

  private final EntityDeletionOrUpdateAdapter<ConsignmentEntity> __updateAdapterOfConsignmentEntity;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsCompleted;

  public ConsignmentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConsignmentEntity = new EntityInsertionAdapter<ConsignmentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `consignments` (`id`,`customerName`,`completed`,`deliveryDate`) VALUES (?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ConsignmentEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getCustomerName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCustomerName());
        }
        final int _tmp = entity.getCompleted() ? 1 : 0;
        statement.bindLong(3, _tmp);
        if (entity.getDeliveryDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getDeliveryDate());
        }
      }
    };
    this.__updateAdapterOfConsignmentEntity = new EntityDeletionOrUpdateAdapter<ConsignmentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `consignments` SET `id` = ?,`customerName` = ?,`completed` = ?,`deliveryDate` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ConsignmentEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getCustomerName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCustomerName());
        }
        final int _tmp = entity.getCompleted() ? 1 : 0;
        statement.bindLong(3, _tmp);
        if (entity.getDeliveryDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getDeliveryDate());
        }
        if (entity.getId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getId());
        }
      }
    };
    this.__preparedStmtOfMarkAsCompleted = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE consignments SET completed = 1, deliveryDate = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final ConsignmentEntity consignment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfConsignmentEntity.insert(consignment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final ConsignmentEntity consignment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfConsignmentEntity.handle(consignment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object markAsCompleted(final String consignmentId, final long deliveryDate,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsCompleted.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, deliveryDate);
        _argIndex = 2;
        if (consignmentId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, consignmentId);
        }
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
          __preparedStmtOfMarkAsCompleted.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ConsignmentEntity>> getOngoing() {
    final String _sql = "SELECT * FROM consignments WHERE completed = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"consignments"}, new Callable<List<ConsignmentEntity>>() {
      @Override
      @NonNull
      public List<ConsignmentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfDeliveryDate = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveryDate");
          final List<ConsignmentEntity> _result = new ArrayList<ConsignmentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ConsignmentEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final Long _tmpDeliveryDate;
            if (_cursor.isNull(_cursorIndexOfDeliveryDate)) {
              _tmpDeliveryDate = null;
            } else {
              _tmpDeliveryDate = _cursor.getLong(_cursorIndexOfDeliveryDate);
            }
            _item = new ConsignmentEntity(_tmpId,_tmpCustomerName,_tmpCompleted,_tmpDeliveryDate);
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
  public Flow<List<ConsignmentEntity>> getCompleted() {
    final String _sql = "SELECT * FROM consignments WHERE completed = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"consignments"}, new Callable<List<ConsignmentEntity>>() {
      @Override
      @NonNull
      public List<ConsignmentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfDeliveryDate = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveryDate");
          final List<ConsignmentEntity> _result = new ArrayList<ConsignmentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ConsignmentEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final Long _tmpDeliveryDate;
            if (_cursor.isNull(_cursorIndexOfDeliveryDate)) {
              _tmpDeliveryDate = null;
            } else {
              _tmpDeliveryDate = _cursor.getLong(_cursorIndexOfDeliveryDate);
            }
            _item = new ConsignmentEntity(_tmpId,_tmpCustomerName,_tmpCompleted,_tmpDeliveryDate);
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
  public Flow<ConsignmentEntity> getById(final String consignmentId) {
    final String _sql = "SELECT * FROM consignments WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (consignmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, consignmentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"consignments"}, new Callable<ConsignmentEntity>() {
      @Override
      @Nullable
      public ConsignmentEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfDeliveryDate = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveryDate");
          final ConsignmentEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final boolean _tmpCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp != 0;
            final Long _tmpDeliveryDate;
            if (_cursor.isNull(_cursorIndexOfDeliveryDate)) {
              _tmpDeliveryDate = null;
            } else {
              _tmpDeliveryDate = _cursor.getLong(_cursorIndexOfDeliveryDate);
            }
            _result = new ConsignmentEntity(_tmpId,_tmpCustomerName,_tmpCompleted,_tmpDeliveryDate);
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
