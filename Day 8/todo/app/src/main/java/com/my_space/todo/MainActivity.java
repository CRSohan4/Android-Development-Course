package com.my_space.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button saveBtn;
    private EditText todoEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: We are in onCreate state");

        saveBtn = findViewById(R.id.saveBtn);
        todoEt = findViewById(R.id.todoEt);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add logic here
                writeToFile(todoEt.getText().toString());
            }
        });

        if(readFromFile() != null){
            todoEt.setText(readFromFile());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: We are in onStart state");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: We are in onResume state");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: We are in onPause state");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop: We are in onStop state");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: We are in onDestroy state");
    }

    private void writeToFile(String message){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("todolist.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile(){
        String result = "";

        try {
            InputStream inputStream = openFileInput("todolist.txt");

            if(inputStream != null){
                // file has some text, fetch those lines
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String tempString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while((tempString = bufferedReader.readLine()) != null){
                    stringBuilder.append(tempString);
                }
                result = stringBuilder.toString();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}