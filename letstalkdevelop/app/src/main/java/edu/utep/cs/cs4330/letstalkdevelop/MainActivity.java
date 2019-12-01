package edu.utep.cs.cs4330.letstalkdevelop;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> items;
    Adapter adapter;
    ArrayList<Integer> templateImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        items = new ArrayList<>();
        items.add("Biennale Template");
        items.add("Nirvana Template");
        items.add("Modern Template");
        items.add("Traditional Template");
        items.add("Ivana Template");

        templateImages = new ArrayList<>();
        templateImages.add(R.drawable.website1);
        templateImages.add(R.drawable.website2);
        templateImages.add(R.drawable.website3);
        templateImages.add(R.drawable.website4);
        templateImages.add(R.drawable.website5);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items, templateImages);//setting the adapter for the items(names)
        recyclerView.setAdapter(adapter);

    }
}