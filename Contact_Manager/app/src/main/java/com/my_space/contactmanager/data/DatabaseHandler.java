package com.my_space.contactmanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.my_space.contactmanager.model.Contact;
import com.my_space.contactmanager.util.Util;

import java.util.ArrayList;
import java.util.List;

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
     * CRUD Operations : CREATE/ADD, READ, UPDATE, DELETE
     */

    // Add contact
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        // similar to Hashmap in JAVA and Dictionary in Python
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.PHONE_NUMBER, contact.getPhoneNumber());

        db.insert(Util.TABLE_NAME, null, values);
        db.close();
    }

    // id   name        phonenumber
    // 1    Sohan       12345748
    // 2    Foodie      37473939
    // Get single contact
    public Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor
        // select id, name, phone_number from contacts where id = 1
        Cursor cursor = db.query(Util.TABLE_NAME
                , new String[]{Util.KEY_ID, Util.KEY_NAME, Util.PHONE_NUMBER}
                , Util.KEY_ID + "=?", new String[] {String.valueOf(id)},
                null, null, null, null
                );

        if(cursor != null){
            cursor.moveToFirst();
        }

        // cursor should ideally look like this -> [ 1, 'Sohan', '12345748']
        Contact contact = new Contact();
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setPhoneNumber(cursor.getString(2));

        return contact;
    }

    // id   name        phonenumber
    // 1    Sohan       12345748
    // 2    Foodie      37473939
    // Get All contacts
    public List<Contact> getAllContacts(){
        SQLiteDatabase db = this.getReadableDatabase();

        // This is how data looks in contactlist variable
//        [[1    Sohan       12345748], [2    Foodie      37473939]]
        List<Contact> contactList = new ArrayList<>();

        // select all query
        // select * from contacts
        String query = "SELECT * FROM " + Util.TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                // cursor should ideally look like this -> [ 1, 'Sohan', '12345748']
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                contactList.add(contact);
            }while (cursor.moveToNext());
        }

        return contactList;
    }

    // update contact
    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.PHONE_NUMBER, contact.getPhoneNumber());

//      update contacts set values = "values" where id = 3
        return db.update(Util.TABLE_NAME
                , values
                , Util.KEY_ID + "=?"
                , new String[]{String.valueOf(contact.getId())}
                );
    }

    // delete contact
    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Util.TABLE_NAME
                , Util.KEY_ID + "=?"
                , new String[]{String.valueOf(id)}
        );

        db.close();
    }

    // get contacts count
    public int getContactsCount(){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM  " + Util.TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        return cursor.getCount();
    }

    // check whether the name exist or not
    public boolean isContactPresent(String name){
        SQLiteDatabase db = this.getReadableDatabase();

        // select * from contacts where name = 'Shreya'
        Cursor cursor = db.query(Util.TABLE_NAME
                , new String[]{Util.KEY_ID, Util.KEY_NAME, Util.PHONE_NUMBER}
                , Util.KEY_NAME + "=?", new String[]{name}
                , null, null, null, null
                );

        if(cursor != null){
            cursor.moveToFirst();
        }

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
