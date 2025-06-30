package com.example.modernandroidapp.data;

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
import com.example.modernandroidapp.data.dao.ConsignmentDao;
import com.example.modernandroidapp.data.dao.ConsignmentDao_Impl;
import com.example.modernandroidapp.data.dao.ConsignmentItemDao;
import com.example.modernandroidapp.data.dao.ConsignmentItemDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ConsignmentDao _consignmentDao;

  private volatile ConsignmentItemDao _consignmentItemDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `consignments` (`id` TEXT NOT NULL, `customerName` TEXT NOT NULL, `completed` INTEGER NOT NULL, `deliveryDate` INTEGER, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `consignment_items` (`id` TEXT NOT NULL, `consignmentId` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `quantity` INTEGER NOT NULL, `deliveredQuantity` INTEGER NOT NULL, `reminderFrequency` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`consignmentId`) REFERENCES `consignments`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_consignment_items_consignmentId` ON `consignment_items` (`consignmentId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '796e295f776e72f869d1ef0bd4b7b4be')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `consignments`");
        db.execSQL("DROP TABLE IF EXISTS `consignment_items`");
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
        db.execSQL("PRAGMA foreign_keys = ON");
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
        final HashMap<String, TableInfo.Column> _columnsConsignments = new HashMap<String, TableInfo.Column>(4);
        _columnsConsignments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignments.put("customerName", new TableInfo.Column("customerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignments.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignments.put("deliveryDate", new TableInfo.Column("deliveryDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConsignments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConsignments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConsignments = new TableInfo("consignments", _columnsConsignments, _foreignKeysConsignments, _indicesConsignments);
        final TableInfo _existingConsignments = TableInfo.read(db, "consignments");
        if (!_infoConsignments.equals(_existingConsignments)) {
          return new RoomOpenHelper.ValidationResult(false, "consignments(com.example.modernandroidapp.data.entity.ConsignmentEntity).\n"
                  + " Expected:\n" + _infoConsignments + "\n"
                  + " Found:\n" + _existingConsignments);
        }
        final HashMap<String, TableInfo.Column> _columnsConsignmentItems = new HashMap<String, TableInfo.Column>(7);
        _columnsConsignmentItems.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignmentItems.put("consignmentId", new TableInfo.Column("consignmentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignmentItems.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignmentItems.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignmentItems.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignmentItems.put("deliveredQuantity", new TableInfo.Column("deliveredQuantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConsignmentItems.put("reminderFrequency", new TableInfo.Column("reminderFrequency", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConsignmentItems = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysConsignmentItems.add(new TableInfo.ForeignKey("consignments", "CASCADE", "NO ACTION", Arrays.asList("consignmentId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesConsignmentItems = new HashSet<TableInfo.Index>(1);
        _indicesConsignmentItems.add(new TableInfo.Index("index_consignment_items_consignmentId", false, Arrays.asList("consignmentId"), Arrays.asList("ASC")));
        final TableInfo _infoConsignmentItems = new TableInfo("consignment_items", _columnsConsignmentItems, _foreignKeysConsignmentItems, _indicesConsignmentItems);
        final TableInfo _existingConsignmentItems = TableInfo.read(db, "consignment_items");
        if (!_infoConsignmentItems.equals(_existingConsignmentItems)) {
          return new RoomOpenHelper.ValidationResult(false, "consignment_items(com.example.modernandroidapp.data.entity.ConsignmentItemEntity).\n"
                  + " Expected:\n" + _infoConsignmentItems + "\n"
                  + " Found:\n" + _existingConsignmentItems);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "796e295f776e72f869d1ef0bd4b7b4be", "9906c66a02cf6f5c8c3c82c068b57b5b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "consignments","consignment_items");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `consignments`");
      _db.execSQL("DELETE FROM `consignment_items`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
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
    _typeConvertersMap.put(ConsignmentDao.class, ConsignmentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ConsignmentItemDao.class, ConsignmentItemDao_Impl.getRequiredConverters());
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
  public ConsignmentDao consignmentDao() {
    if (_consignmentDao != null) {
      return _consignmentDao;
    } else {
      synchronized(this) {
        if(_consignmentDao == null) {
          _consignmentDao = new ConsignmentDao_Impl(this);
        }
        return _consignmentDao;
      }
    }
  }

  @Override
  public ConsignmentItemDao consignmentItemDao() {
    if (_consignmentItemDao != null) {
      return _consignmentItemDao;
    } else {
      synchronized(this) {
        if(_consignmentItemDao == null) {
          _consignmentItemDao = new ConsignmentItemDao_Impl(this);
        }
        return _consignmentItemDao;
      }
    }
  }
}
