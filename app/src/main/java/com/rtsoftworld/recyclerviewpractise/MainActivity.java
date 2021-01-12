package com.rtsoftworld.recyclerviewpractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rtsoftworld.recyclerviewpractise.Adapter.MyAdapter;
import com.rtsoftworld.recyclerviewpractise.Model.ListItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItems> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();  // turn list into array

        for (int i = 0; i<10; i++)
        {
            ListItems items = new ListItems(
                    "Item" + (i+1),
                    "description" + (i+1)
            );
            listItems.add(items);
        }

        adapter = new MyAdapter(this,listItems);
        recyclerView.setAdapter(adapter); // all data set to recycler view for showing
    }
}