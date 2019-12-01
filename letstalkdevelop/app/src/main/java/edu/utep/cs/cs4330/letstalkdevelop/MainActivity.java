package edu.utep.cs.cs4330.letstalkdevelop;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.loginMenu:
                Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginActivity);
                finish();
                return true;
            case R.id.registerMenu:
                Intent registerActivity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

