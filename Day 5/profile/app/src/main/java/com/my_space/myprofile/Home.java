package com.my_space.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button profileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profileBtn = findViewById(R.id.profileBtn);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = getIntent().getStringExtra("username");

                Intent intent = new Intent(Home.this, ProfileActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}