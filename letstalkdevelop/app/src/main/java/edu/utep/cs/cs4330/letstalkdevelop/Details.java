package edu.utep.cs.cs4330.letstalkdevelop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView textTitle;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Setting Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.imageView2);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        Bundle b = getIntent().getExtras();
        int imag = b.getInt("image");


        textTitle.setText(title);
        detailImage.setImageResource(imag);
    }
}