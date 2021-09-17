package com.my_space.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEt, passwordEt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEt = findViewById(R.id.usernameEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = usernameEt.getText().toString();
                String passwordString = passwordEt.getText().toString();

                // Users -> Rohit, Virat
                // Passwords -> Sharma, Kohli

                if(usernameString.equals("Rohit") && passwordString.equals("Sharma")){
                    // login success
                    Toast.makeText(MainActivity.this, "Welcome Rohit", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Home.class);
                    intent.putExtra("username", usernameString);
                    startActivity(intent);
                    finish();

                }else if(usernameString.equals("Virat") && passwordString.equals("Kohli")){
                    // login success
                    Toast.makeText(MainActivity.this, "Welcome Virat", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, Home.class);
                    intent.putExtra("username", usernameString);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}