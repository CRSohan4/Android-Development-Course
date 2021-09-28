package com.my_space.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

    private EditText nameEt, phoneNumberEt;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        nameEt = findViewById(R.id.nameEt);
        phoneNumberEt = findViewById(R.id.phoneNumberEt);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}