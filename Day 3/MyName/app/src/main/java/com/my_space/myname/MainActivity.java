package com.my_space.myname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button showButton;
    private TextView showName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        showButton = findViewById(R.id.showButton);
        showName = findViewById(R.id.showName);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String template = "Your name is ";

                showName.setText(template + nameString);
                showName.setTextSize(25);
                showName.setVisibility(View.VISIBLE);
            }
        });

    }
}