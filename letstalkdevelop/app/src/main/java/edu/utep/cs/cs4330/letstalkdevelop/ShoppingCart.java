package edu.utep.cs.cs4330.letstalkdevelop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {
    ArrayList<String> item;
    ArrayList<Integer> image;
    ArrayList<String> description;
    ArrayList<Double> price;
    ListView shoppingCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        shoppingCart = (ListView) findViewById(R.id.shoppingCart);
        item = new ArrayList<>();
        image = new ArrayList<>();
        description = new ArrayList<>();
        price = new ArrayList<>();


        Intent i = getIntent();

        item.add(i.getStringExtra("title"));
        //Image
        Bundle b = getIntent().getExtras();
        int imag = b.getInt("image");
        //Description
        String description = i.getStringExtra("description");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, item);
        shoppingCart.setAdapter(arrayAdapter);
    }
}
