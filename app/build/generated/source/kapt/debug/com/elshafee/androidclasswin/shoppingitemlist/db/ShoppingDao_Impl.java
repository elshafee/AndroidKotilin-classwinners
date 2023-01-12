package com.elshafee.androidclasswin.shoppingitemlist.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.elshafee.androidclasswin.shoppingitemlist.model.ShoppingItem;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ShoppingDao_Impl implements ShoppingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ShoppingItem> __insertionAdapterOfShoppingItem;

  private final EntityDeletionOrUpdateAdapter<ShoppingItem> __deletionAdapterOfShoppingItem;

  public ShoppingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfShoppingItem = new EntityInsertionAdapter<ShoppingItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `shopping_items` (`item_name`,`item_amount`,`id`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ShoppingItem value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        stmt.bindLong(2, value.getAmount());
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
      }
    };
    this.__deletionAdapterOfShoppingItem = new EntityDeletionOrUpdateAdapter<ShoppingItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `shopping_items` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ShoppingItem value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public void upsert(final ShoppingItem item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfShoppingItem.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ShoppingItem item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfShoppingItem.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<ShoppingItem>> getAllShoppingItem() {
    final String _sql = "SELECT * FROM shopping_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"shopping_items"}, false, new Callable<List<ShoppingItem>>() {
      @Override
      public List<ShoppingItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "item_name");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "item_amount");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<ShoppingItem> _result = new ArrayList<ShoppingItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ShoppingItem _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpAmount;
            _tmpAmount = _cursor.getInt(_cursorIndexOfAmount);
            _item = new ShoppingItem(_tmpName,_tmpAmount);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
