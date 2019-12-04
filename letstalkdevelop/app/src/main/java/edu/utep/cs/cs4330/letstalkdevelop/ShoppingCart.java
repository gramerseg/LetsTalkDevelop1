package edu.utep.cs.cs4330.letstalkdevelop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {
    private Button buyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

<<<<<<< HEAD
        buyButton = (Button) findViewById(R.id.buy_button);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        ShoppingDialog shoppingDialog = new ShoppingDialog();
        shoppingDialog.show(getSupportFragmentManager(),"example dialog");
    }

    

=======
        Intent i = getIntent();
        if (i.getStringExtra("title")== null) {
           return;
        }
        else {
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
>>>>>>> e304abd367a42d68c7d291ae81670c17e014f1e9
}
