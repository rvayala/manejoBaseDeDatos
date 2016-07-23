package com.rvag.manejobasededatoscontacto.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Robert on 16/07/2016.
 */
public class DataBaseAdapter extends SQLiteOpenHelper {

    public DataBaseAdapter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, twitter TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
