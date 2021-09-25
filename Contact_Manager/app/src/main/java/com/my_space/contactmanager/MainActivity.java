package com.my_space.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create table
//        create table table_name (
//                name Text primary key,
//                Food Text,
//                boy Text
//        )

        // CRUD - Create/Add, Read, Update and Delete
        // Add data to the table
//        insert into table values("Fido", "Dry", "Y");

        // Read data from the table
//        select * from table
        // read data from the table where food is wet
//        select * from table where Food = 'wet'
    }

}