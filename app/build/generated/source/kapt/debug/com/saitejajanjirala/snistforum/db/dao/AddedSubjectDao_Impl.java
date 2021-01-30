package com.saitejajanjirala.snistforum.db.dao;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.saitejajanjirala.snistforum.db.entities.AddedSubject;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddedSubjectDao_Impl implements AddedSubjectDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAddedSubject;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAddedSubject;

  public AddedSubjectDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddedSubject = new EntityInsertionAdapter<AddedSubject>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `addedsubjects`(`subjectName`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddedSubject value) {
        if (value.getSubjectName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSubjectName());
        }
      }
    };
    this.__deletionAdapterOfAddedSubject = new EntityDeletionOrUpdateAdapter<AddedSubject>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `addedsubjects` WHERE `subjectName` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddedSubject value) {
        if (value.getSubjectName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSubjectName());
        }
      }
    };
  }

  @Override
  public Single<Long> insert(final AddedSubject subject) {
    return Single.fromCallable(new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfAddedSubject.insertAndReturnId(subject);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Single<Integer> deleteSubject(final AddedSubject addedSubject) {
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfAddedSubject.handle(addedSubject);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Single<Integer> getSize() {
    final String _sql = "select count(*) from addedsubjects";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
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
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
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
  public Single<List<AddedSubject>> getAllSubjects() {
    final String _sql = "select * from addedsubjects";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<List<AddedSubject>>() {
      @Override
      public List<AddedSubject> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfSubjectName = CursorUtil.getColumnIndexOrThrow(_cursor, "subjectName");
          final List<AddedSubject> _result = new ArrayList<AddedSubject>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final AddedSubject _item;
            final String _tmpSubjectName;
            _tmpSubjectName = _cursor.getString(_cursorIndexOfSubjectName);
            _item = new AddedSubject(_tmpSubjectName);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
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
}
