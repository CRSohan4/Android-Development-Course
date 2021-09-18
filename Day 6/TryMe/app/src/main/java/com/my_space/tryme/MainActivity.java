package com.my_space.tryme;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View view;
    private Button tryMeBtn;
    private int[] colors;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = new int[]{Color.CYAN, Color.GREEN, Color.RED, Color.BLUE, Color.BLACK, Color.DKGRAY, Color.LTGRAY,
        Color.MAGENTA, Color.YELLOW};

        view = findViewById(R.id.view);
        tryMeBtn = findViewById(R.id.tryMeBtn);

        tryMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int colorArrayLength = colors.length;
                int randomNum = random.nextInt(colorArrayLength);

                view.setBackgroundColor(colors[randomNum]);

                Log.d(TAG, "onClick: " + randomNum );
            }
        });
    }
}