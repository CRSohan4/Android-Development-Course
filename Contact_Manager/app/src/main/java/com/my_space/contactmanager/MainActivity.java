package com.my_space.contactmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.my_space.contactmanager.adapter.MyAdapter;
import com.my_space.contactmanager.data.DatabaseHandler;
import com.my_space.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHandler db = new DatabaseHandler(this);
        contactList = db.getAllContacts();

        adapter = new MyAdapter(this, contactList);
        recyclerView.setAdapter(adapter);

//        Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
//        startActivity(intent);

//        DatabaseHandler db = new DatabaseHandler(this);
//
//        Log.d(TAG, "onCreate: No. of contacts in the list are " + String.valueOf(db.getContactsCount()));
//
//        Log.d(TAG, "onCreate: Adding Contacts");
//        db.addContact(new Contact("Sushil", "46382837"));
//        db.addContact(new Contact("Foodie", "76382837"));
//        db.addContact(new Contact("Manthan", "26382837"));
//        db.addContact(new Contact("Shreya", "86382837"));
//        Log.d(TAG, "onCreate: Contacts created");

//        Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
//        startActivity(intent);

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

//        Log.d(TAG, "onCreate: Reading all contacts");
//        List<Contact> contacts = db.getAllContacts();
//        for (Contact contact : contacts){
//            Log.d(TAG, "onCreate: id " + contact.getId() + " name: " + contact.getName() + " phone: "
//                    + contact.getPhoneNumber()) ;
//        }
//
//        Log.d(TAG, "onCreate: Deleting a contact");
//        db.deleteContact(5);
//        Log.d(TAG, "onCreate: Contact deleted successfully");
//
//        Log.d(TAG, "onCreate: Reading all contacts");
//        List<Contact> contacts1 = db.getAllContacts();
//        for (Contact contact : contacts1){
//            Log.d(TAG, "onCreate: id " + contact.getId() + " name: " + contact.getName() + " phone: "
//                    + contact.getPhoneNumber()) ;
//        }

    }

    // Menu rules
    // 1) we need to connect/map the menu xml file to the activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    // 2) we need to handle the onClick
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.addBtnMenu:
                // add button is clicked
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
                return true;
        }
        return true;
    }
}