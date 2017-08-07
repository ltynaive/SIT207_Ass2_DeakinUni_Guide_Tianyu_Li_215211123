package com.example.lty.tianyu_li_215211123;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CustomOpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "message";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MESSAGE = "message";

    private static final String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_NAME + " text not null, " + COLUMN_MESSAGE + " integer not null);";

    public CustomOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
