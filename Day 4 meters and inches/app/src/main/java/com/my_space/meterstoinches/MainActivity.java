package com.my_space.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText metersEt;
    private Button convertBtn;
    private TextView showInchesTv;

    // 1 meter = 39.37 inches
    // 2 meters = 2 * 39.37 inches

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metersEt = findViewById(R.id.metersEt);
        convertBtn = findViewById(R.id.convertBtn);
        showInchesTv = findViewById(R.id.showInchesTv);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double constantValue = 39.37;
                double result = 0.0;

                if(metersEt.getText().toString().equals("")){
                    metersEt.setError("Please enter meters!");
                    showInchesTv.setVisibility(View.INVISIBLE);
                }else{
                    double meters = Double.parseDouble(metersEt.getText().toString());
                    // 2 meters = 2 * 39.37 inches
                    result = meters * constantValue;

                    showInchesTv.setText(String.format("%.2f", result));
                    showInchesTv.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}