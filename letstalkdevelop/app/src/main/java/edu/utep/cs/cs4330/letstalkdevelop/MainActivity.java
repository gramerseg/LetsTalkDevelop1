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
    ArrayList<String> description;
    ArrayList<Double> prices;
    private SessionHandler session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
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

        description = new ArrayList<>();
        description.add("Breath-taking template delivers an open-space layout perfect for business.");
        description.add("2Breath-taking template delivers an open-space layout perfect for business.");
        description.add("3Breath-taking template delivers an open-space layout perfect for business.");
        description.add("4Breath-taking template delivers an open-space layout perfect for business.");
        description.add("5Breath-taking template delivers an open-space layout perfect for business.");

        prices = new ArrayList<>();
        prices.add(99.99);
        prices.add(69.99);
        prices.add(59.99);
        prices.add(85.99);
        prices.add(75.99);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items, templateImages, description, prices);//setting the adapter for the items(names)
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
            case R.id.shoppingCartMenu:
                return true;
            case R.id.logoutMenu:
                session.logoutUser();
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}

