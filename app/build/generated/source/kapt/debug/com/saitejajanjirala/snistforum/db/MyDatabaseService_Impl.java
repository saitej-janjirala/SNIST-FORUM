package com.saitejajanjirala.snistforum.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.saitejajanjirala.snistforum.db.dao.AddedSubjectDao;
import com.saitejajanjirala.snistforum.db.dao.AddedSubjectDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDatabaseService_Impl extends MyDatabaseService {
  private volatile AddedSubjectDao _addedSubjectDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `addedsubjects` (`subjectName` TEXT NOT NULL, PRIMARY KEY(`subjectName`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"191458aebe6864156ee995b97e329500\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `addedsubjects`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAddedsubjects = new HashMap<String, TableInfo.Column>(1);
        _columnsAddedsubjects.put("subjectName", new TableInfo.Column("subjectName", "TEXT", true, 1));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddedsubjects = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddedsubjects = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddedsubjects = new TableInfo("addedsubjects", _columnsAddedsubjects, _foreignKeysAddedsubjects, _indicesAddedsubjects);
        final TableInfo _existingAddedsubjects = TableInfo.read(_db, "addedsubjects");
        if (! _infoAddedsubjects.equals(_existingAddedsubjects)) {
          throw new IllegalStateException("Migration didn't properly handle addedsubjects(com.saitejajanjirala.snistforum.db.entities.AddedSubject).\n"
                  + " Expected:\n" + _infoAddedsubjects + "\n"
                  + " Found:\n" + _existingAddedsubjects);
        }
      }
    }, "191458aebe6864156ee995b97e329500", "afd19cecac99a68a75f8c0e76f72019e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "addedsubjects");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `addedsubjects`");
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
  public AddedSubjectDao addedSubjectDao() {
    if (_addedSubjectDao != null) {
      return _addedSubjectDao;
    } else {
      synchronized(this) {
        if(_addedSubjectDao == null) {
          _addedSubjectDao = new AddedSubjectDao_Impl(this);
        }
        return _addedSubjectDao;
      }
    }
  }
}
