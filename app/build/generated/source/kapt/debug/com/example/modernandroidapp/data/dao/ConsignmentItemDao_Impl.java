package com.example.modernandroidapp.data.dao;

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
import com.example.modernandroidapp.data.entity.ConsignmentItemEntity;
import java.lang.Class;
import java.lang.Exception;
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
public final class ConsignmentItemDao_Impl implements ConsignmentItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ConsignmentItemEntity> __insertionAdapterOfConsignmentItemEntity;

  private final EntityDeletionOrUpdateAdapter<ConsignmentItemEntity> __updateAdapterOfConsignmentItemEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDeliveredQuantity;

  public ConsignmentItemDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConsignmentItemEntity = new EntityInsertionAdapter<ConsignmentItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `consignment_items` (`id`,`consignmentId`,`name`,`description`,`quantity`,`deliveredQuantity`,`reminderFrequency`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ConsignmentItemEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getConsignmentId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getConsignmentId());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        statement.bindLong(5, entity.getQuantity());
        statement.bindLong(6, entity.getDeliveredQuantity());
        if (entity.getReminderFrequency() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getReminderFrequency());
        }
      }
    };
    this.__updateAdapterOfConsignmentItemEntity = new EntityDeletionOrUpdateAdapter<ConsignmentItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `consignment_items` SET `id` = ?,`consignmentId` = ?,`name` = ?,`description` = ?,`quantity` = ?,`deliveredQuantity` = ?,`reminderFrequency` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ConsignmentItemEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getConsignmentId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getConsignmentId());
        }
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getName());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        statement.bindLong(5, entity.getQuantity());
        statement.bindLong(6, entity.getDeliveredQuantity());
        if (entity.getReminderFrequency() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getReminderFrequency());
        }
        if (entity.getId() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateDeliveredQuantity = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE consignment_items SET deliveredQuantity = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final ConsignmentItemEntity item, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfConsignmentItemEntity.insert(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertAll(final List<ConsignmentItemEntity> items,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfConsignmentItemEntity.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object update(final ConsignmentItemEntity item, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfConsignmentItemEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateDeliveredQuantity(final String itemId, final int deliveredQuantity,
      final Continuation<? super Unit> arg2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDeliveredQuantity.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, deliveredQuantity);
        _argIndex = 2;
        if (itemId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, itemId);
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
          __preparedStmtOfUpdateDeliveredQuantity.release(_stmt);
        }
      }
    }, arg2);
  }

  @Override
  public Flow<List<ConsignmentItemEntity>> getItems(final String consignmentId) {
    final String _sql = "SELECT * FROM consignment_items WHERE consignmentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (consignmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, consignmentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"consignment_items"}, new Callable<List<ConsignmentItemEntity>>() {
      @Override
      @NonNull
      public List<ConsignmentItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfConsignmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "consignmentId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfDeliveredQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredQuantity");
          final int _cursorIndexOfReminderFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderFrequency");
          final List<ConsignmentItemEntity> _result = new ArrayList<ConsignmentItemEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ConsignmentItemEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpConsignmentId;
            if (_cursor.isNull(_cursorIndexOfConsignmentId)) {
              _tmpConsignmentId = null;
            } else {
              _tmpConsignmentId = _cursor.getString(_cursorIndexOfConsignmentId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpDeliveredQuantity;
            _tmpDeliveredQuantity = _cursor.getInt(_cursorIndexOfDeliveredQuantity);
            final String _tmpReminderFrequency;
            if (_cursor.isNull(_cursorIndexOfReminderFrequency)) {
              _tmpReminderFrequency = null;
            } else {
              _tmpReminderFrequency = _cursor.getString(_cursorIndexOfReminderFrequency);
            }
            _item = new ConsignmentItemEntity(_tmpId,_tmpConsignmentId,_tmpName,_tmpDescription,_tmpQuantity,_tmpDeliveredQuantity,_tmpReminderFrequency);
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
  public Flow<List<ConsignmentItemEntity>> getAllItems() {
    final String _sql = "SELECT * FROM consignment_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"consignment_items"}, new Callable<List<ConsignmentItemEntity>>() {
      @Override
      @NonNull
      public List<ConsignmentItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfConsignmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "consignmentId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfDeliveredQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "deliveredQuantity");
          final int _cursorIndexOfReminderFrequency = CursorUtil.getColumnIndexOrThrow(_cursor, "reminderFrequency");
          final List<ConsignmentItemEntity> _result = new ArrayList<ConsignmentItemEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ConsignmentItemEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpConsignmentId;
            if (_cursor.isNull(_cursorIndexOfConsignmentId)) {
              _tmpConsignmentId = null;
            } else {
              _tmpConsignmentId = _cursor.getString(_cursorIndexOfConsignmentId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpDeliveredQuantity;
            _tmpDeliveredQuantity = _cursor.getInt(_cursorIndexOfDeliveredQuantity);
            final String _tmpReminderFrequency;
            if (_cursor.isNull(_cursorIndexOfReminderFrequency)) {
              _tmpReminderFrequency = null;
            } else {
              _tmpReminderFrequency = _cursor.getString(_cursorIndexOfReminderFrequency);
            }
            _item = new ConsignmentItemEntity(_tmpId,_tmpConsignmentId,_tmpName,_tmpDescription,_tmpQuantity,_tmpDeliveredQuantity,_tmpReminderFrequency);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
