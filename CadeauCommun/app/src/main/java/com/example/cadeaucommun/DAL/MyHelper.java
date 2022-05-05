package com.example.cadeaucommun.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {
    public static final String dbName = "cadeaux.db";
    public static final int version = 1;

    public MyHelper(@Nullable Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE participant(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "firstName TEXT, " +
                "lastName TEXT, " +
                "username TEXT, " +
                "password TEXT, " +
                "image TEXT)"
        );

        db.execSQL("CREATE TABLE cadeau(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT, " +
                "description TEXT, " +
                "goal REAL)"
        );

        db.execSQL("CREATE TABLE evenement(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT, " +
                "description TEXT, " +
                "beginDate TEXT," +
                "endDate TEXT,"  +
                "FOREIGN KEY (OrganizerID) REFERENCES participant(id))"
        );

        db.execSQL("CREATE TABLE invitation(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "rsvp TEXT," +
                "participantID INTEGER," +
                "eventID INTEGER," +
                "FOREIGN KEY(participantID) REFERENCES participant(id)," +
                "FOREIGN KEY(eventID) REFERENCES evenement(id))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS participants");
        db.execSQL("DROP TABLE IF EXISTS cadeau");
        db.execSQL("DROP TABLE IF EXISTS evenement");
        db.execSQL("DROP TABLE IF EXISTS invitation");
    }
}
