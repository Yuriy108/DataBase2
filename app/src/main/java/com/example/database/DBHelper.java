package com.example.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="userdb.db";
    private static final int SCHENA=1;
    static final String TABLE="users";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_AGE="age";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,SCHENA);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT, "+COLUMN_AGE+" INTEGER);");
        db.execSQL("INSERT INTO "+TABLE+" ("+COLUMN_NAME+", "+COLUMN_AGE+") VALUES ('Yura',40);");
        db.execSQL("INSERT INTO "+TABLE+" ("+COLUMN_NAME+", "+COLUMN_AGE+") VALUES ('Vova',10);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);

    }
}
