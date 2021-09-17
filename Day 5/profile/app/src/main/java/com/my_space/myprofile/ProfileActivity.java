package com.my_space.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameProfileTv;
    private ImageView profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameProfileTv = findViewById(R.id.usernameProfileTv);
        profilePic = findViewById(R.id.profilePic);

        String username = getIntent().getStringExtra("username");
        usernameProfileTv.setText("Hi " + username);
    }
}