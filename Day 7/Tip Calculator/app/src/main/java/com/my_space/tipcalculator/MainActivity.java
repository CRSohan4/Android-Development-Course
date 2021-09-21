package com.my_space.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tipPercentTv, billDisplayTv, tipDisplayTv;
    private SeekBar seekBar;
    private EditText billEt;
    private Button calculate;

    private int tipValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipPercentTv = findViewById(R.id.tipPercentTv);
        billDisplayTv = findViewById(R.id.billDisplayTv);
        tipDisplayTv = findViewById(R.id.tipDisplayTv);
        seekBar = findViewById(R.id.tipSeekbar);
        billEt = findViewById(R.id.billEt);
        calculate = findViewById(R.id.calculateBtn);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = 0.0;

                if(!billEt.getText().toString().equals("")){
                    double billValue = Double.parseDouble(billEt.getText().toString());

                    result = billValue * tipValue / 100;

                    tipDisplayTv.setText("Your tip will be $" + String.valueOf(result));

                    billDisplayTv.setText("Your total bill is $" + String.valueOf(billValue + result));
                }

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercentTv.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tipValue = seekBar.getProgress();
            }
        });


    }
}