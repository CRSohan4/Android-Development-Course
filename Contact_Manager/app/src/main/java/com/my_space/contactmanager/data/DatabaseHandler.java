package com.my_space.contactmanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.my_space.contactmanager.model.Contact;
import com.my_space.contactmanager.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        CREATE TABLE contacts (
//                id INTEGER PRIMARY KEY,
//                name TEXT,
//                phone_number TEXT
//        )

        String createQuery = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_NAME + " TEXT,"
                + Util.PHONE_NUMBER + " TEXT"
                + ")";

        db.execSQL(createQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop/delete existing table
        String deleteQuery = "DROP TABLE IF EXISTS " + Util.TABLE_NAME;
        db.execSQL(deleteQuery);

        // create the table again
        onCreate(db);
    }

    /**
     * CRUD Operations : CREATE, READ, UPDATE, DELETE
     */

    // Add contact
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.PHONE_NUMBER, contact.getPhoneNumber());

        db.insert(Util.TABLE_NAME, null, values);
        db.close();
    }
}
