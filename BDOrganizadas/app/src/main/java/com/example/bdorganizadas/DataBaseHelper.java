package com.example.bdorganizadas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper {
    private Context mCtx=null;
    private DataBaseHelperInternal mDbHelper=null;
    private SQLiteDatabase mDb=null;
    private static final String DATABASE_NAME="DBClientes";
    private static final int DATABASE_VERSION=3;
    private static final String DATABASE_TABLE_CLIENTES="Clientes";
    private static final String CODIGO="codigo";
    private static final String NOMBRE="nombre";
    private static final String TELEFONO="telefono";
    private static final String DATABASE_CREATE_CLIENTES= "create table "+ DATABASE_TABLE_CLIENTES +" ("+ CODIGO+" integer primary key ,"+NOMBRE+" text not null,"+"TELEFONO"+" text not null"+")";

    public DataBaseHelper(Context ctx) {
        mCtx=ctx;
    }

    private static class DataBaseHelperInternal extends SQLiteOpenHelper{
        public DataBaseHelperInternal (Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            createTables(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
        }
        private void createTables(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_CLIENTES);
        }
        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_CLIENTES);
        }
    }

    public DataBaseHelper open() {
        mDbHelper = new DataBaseHelperInternal(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public long insertItem(int cod, String nom, String tel){
        ContentValues initialValues = new ContentValues();
        initialValues.put(CODIGO, cod);
        initialValues.put(NOMBRE, nom);
        initialValues.put(TELEFONO, tel);
        return mDb.insert(DATABASE_TABLE_CLIENTES, null, initialValues);
    }

    public Cursor getItems() {
        String[] campos = new String[] {CODIGO, NOMBRE, TELEFONO};
        return mDb.query(DATABASE_TABLE_CLIENTES, campos, null, null, null, null, null);
    }

}
