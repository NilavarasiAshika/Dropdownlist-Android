package com.example.arief.dropdownlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arief on 3/4/2017.
 */
public class BackDB extends SQLiteOpenHelper {
    public BackDB(Context context) {
        super(context, "hujkh", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table studenttable(name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists studenttable");
        onCreate(db);
    }
    public void insertstu(String name)
    {
        SQLiteDatabase obj =getWritableDatabase();
        obj.execSQL("insert into studenttable values('" + name + "')");
    }
    public ArrayList<String> getAllNames(){
        ArrayList<String> names = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM studenttable";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning names
        return names;
    }

}
