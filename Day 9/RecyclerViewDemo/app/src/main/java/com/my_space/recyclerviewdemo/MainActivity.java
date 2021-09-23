package com.my_space.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.my_space.recyclerviewdemo.adapter.MyAdapter;
import com.my_space.recyclerviewdemo.model.MyModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<MyModel> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dummy data created **start**
        listItems = new ArrayList<>();

        for(int i=0; i<10; i++){
//            MyModel myModel = new MyModel(
//                    "Item " + (i + 1),
//                        "Description " + (i + 1)
//                    );
            MyModel myModel = new MyModel();
            myModel.setTitle("Item " + (i + 1));
            myModel.setDescription("Description " + (i + 1));

            listItems.add(myModel);
        }
        // Dummy data created **end**

        adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);

    }
}