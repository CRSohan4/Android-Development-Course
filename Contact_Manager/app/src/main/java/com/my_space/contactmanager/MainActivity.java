package com.my_space.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.my_space.contactmanager.data.DatabaseHandler;
import com.my_space.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
        startActivity(intent);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d(TAG, "onCreate: No. of contacts in the list are " + String.valueOf(db.getContactsCount()));

//        Log.d(TAG, "onCreate: Adding Contacts");
//        db.addContact(new Contact("Sushil", "46382837"));
//        db.addContact(new Contact("Foodie", "76382837"));
//        db.addContact(new Contact("Manthan", "26382837"));
//        db.addContact(new Contact("Shreya", "86382837"));
//        Log.d(TAG, "onCreate: Contacts created");

//        Log.d(TAG, "onCreate: Reading all contacts");
//        List<Contact> contacts = db.getAllContacts();
//        for (Contact contact : contacts){
//            Log.d(TAG, "onCreate: id " + contact.getId() + " name: " + contact.getName() + " phone: "
//                    + contact.getPhoneNumber()) ;
//        }

//        Log.d(TAG, "onCreate: Reading a single contact");
//        Contact singleContact = db.getContact(3);
//        Log.d(TAG, "onCreate: id " + singleContact.getId() +
//                        " name: " + singleContact.getName() + " phone: "
//                    + singleContact.getPhoneNumber());
//
//        Log.d(TAG, "onCreate: Updating the contact");
//        singleContact.setName("Manthan Developer");
//        Log.d(TAG, "onCreate: updated contact " + String.valueOf(db.updateContact(singleContact)));

        Log.d(TAG, "onCreate: Reading all contacts");
        List<Contact> contacts = db.getAllContacts();
        for (Contact contact : contacts){
            Log.d(TAG, "onCreate: id " + contact.getId() + " name: " + contact.getName() + " phone: "
                    + contact.getPhoneNumber()) ;
        }

        Log.d(TAG, "onCreate: Deleting a contact");
        db.deleteContact(5);
        Log.d(TAG, "onCreate: Contact deleted successfully");

        Log.d(TAG, "onCreate: Reading all contacts");
        List<Contact> contacts1 = db.getAllContacts();
        for (Contact contact : contacts1){
            Log.d(TAG, "onCreate: id " + contact.getId() + " name: " + contact.getName() + " phone: "
                    + contact.getPhoneNumber()) ;
        }

    }

}