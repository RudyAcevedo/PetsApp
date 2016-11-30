package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by Rudster on 11/16/2016.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    // database version
    public static final int DATABASE_VERSION = 1;

    //name of database file
    public static final String DATABASE_NAME = "shelter.db";


    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS" + PetContract.PetEntry.TABLE_NAME;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE pets
        String SQL_CREATE_TABLE =
                "CREATE TABLE " + PetEntry.TABLE_NAME + "("
                        + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL,"
                        + PetEntry.COLUMN_PET_BREED + " TEXT,"
                        + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL,"
                        + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //This database is only a cache for online data, so its upgrade policy is simply
        //to discard the data and start over
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);

    }


}
