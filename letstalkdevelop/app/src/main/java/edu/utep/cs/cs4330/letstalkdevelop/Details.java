package edu.utep.cs.cs4330.letstalkdevelop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView textTitle;
    ImageView detailImage;
    TextView detailDescription;
    Button addToCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Setting Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.imageView2);
        detailDescription = findViewById(R.id.detailDescription);
        addToCartButton = findViewById(R.id.addToCartButton);

        Intent i = getIntent();
        //Title
        String title = i.getStringExtra("title");
        //Image
        Bundle b = getIntent().getExtras();
        int imag = b.getInt("image");
        //Description
        String description = i.getStringExtra("description");


        textTitle.setText(title);
        detailImage.setImageResource(imag);
        detailDescription.setText(description);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ShoppingCart.class);
                String title = textTitle.getText().toString();
                Integer image = detailImage.getId();
                String desc = detailDescription.getText().toString();

                i.putExtra("title", title);
                i.putExtra("image", image);
                i.putExtra("description", desc);
                v.getContext().startActivity(i);

            }
        });
    }
}