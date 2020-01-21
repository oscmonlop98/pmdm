package com.example.listatarea1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseHelper {

    private Context mCtx = null;
    private DataBaseHelperInternal mDbHelper = null;
    private SQLiteDatabase mDb = null;
    private static final String DATABASE_NAME = "TODOLIST";
    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_TABLE_TODOLIST = "todolist";
    public static final String SL_ID = "_id";
    public static final String SL_ITEM = "task";
    public static final String SL_PLACE = "place";
    public static final String SL_IMPORTANCE = "importance";
    public static final String SL_DESCRIPTION = "description";

    private static final String DATABASE_CREATE_TODOLIST =
            "create table " + DATABASE_TABLE_TODOLIST + " ("+SL_ID+" integer primary key, "+SL_ITEM+
                    " text not null, "+SL_PLACE+" text not null, "+SL_IMPORTANCE+
                    " integer not null, "+SL_DESCRIPTION+" text)";

    public DataBaseHelper (Context ctx) {
        this.mCtx = ctx;
    }
}
