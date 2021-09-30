package com.my_space.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.my_space.contactmanager.data.DatabaseHandler;
import com.my_space.contactmanager.model.Contact;

import java.util.List;

public class AddContactActivity extends AppCompatActivity {

    private EditText nameEt, phoneNumberEt;
    private Button addBtn;
    private TextView titleTv;

    private String name, phoneNumber, status;

    private static final String TAG = "AddContactActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        DatabaseHandler db = new DatabaseHandler(this);

        nameEt = findViewById(R.id.nameEt);
        phoneNumberEt = findViewById(R.id.phoneNumberEt);
        addBtn = findViewById(R.id.addBtn);
        titleTv = findViewById(R.id.titleTv);


        if(getIntent().hasExtra("status")) {
            status = getIntent().getStringExtra("status");
            name = getIntent().getStringExtra("name");
            phoneNumber = getIntent().getStringExtra("phoneNumber");
            if(status.equals("update")){
                titleTv.setText("Update Contact Details");
                addBtn.setText("Update");
                nameEt.setText(name);
                phoneNumberEt.setText(phoneNumber);
            }
        }




        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEt.getText().toString();
                phoneNumber = phoneNumberEt.getText().toString();

                if(db.isContactPresent(name)){
                    // contact already exist
                    Toast.makeText(AddContactActivity.this, "Contact already exist!", Toast.LENGTH_SHORT).show();
                }else{
                    // add contact
                    Contact contact = new Contact();
                    contact.setName(name);
                    contact.setPhoneNumber(phoneNumber);
                    db.addContact(contact);
//                    db.addContact(new Contact(name, phoneNumber));

                    Log.d(TAG, "onClick:  Contact added successfully");
                    Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                if(getIntent().hasExtra("status")) {
                    Contact contact = new Contact();
                    contact.setName(name);
                    contact.setPhoneNumber(phoneNumber);
                    db.updateContact(contact);

                    Log.d(TAG, "onClick:  Contact updated successfully");
                    Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}