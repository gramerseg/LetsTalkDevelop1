package edu.utep.cs.cs4330.letstalkdevelop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAdapter extends AppCompatActivity {


    private LayoutInflater layoutInflater;
    private List<String> data;
    private List<Integer> imag;
    private List<String> desc;
    private List<Double> price;

    ShoppingCartAdapter(Context context, ArrayList<String> data, ArrayList<Integer> imag, ArrayList<String> desc, ArrayList<Double> prices) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.imag = imag;
        this.desc = desc;
        this.price = prices;
    }


//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = layoutInflater.inflate(R.layout.custom_view,viewGroup,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        //Bind the textview with data received
//        String title = data.get(position);
//        holder.textTitle.setText(title);
//        //Similarly you can set new image/description for each card
//        holder.imageView.setImageResource(imag.get(position));
//        //Description set
//        String description = desc.get(position);
//        holder.textDescription.setText(description);
//        //Prices set
//        String Stringprices = price.get(position).toString();
//        holder.textPrices.setText(Stringprices);
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle;
        TextView textDescription;
        ImageView imageView;
        TextView textPrices;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Set OnCllick Listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //start new intent
                    Intent i = new Intent(view.getContext(), Details.class);

                    i.putExtra("image", imag.get(getAdapterPosition()));
                    i.putExtra("title",data.get(getAdapterPosition())); // Sending title of the CardView
                    i.putExtra("description", desc.get(getAdapterPosition()));
                    i.putExtra("prices", price.get(getAdapterPosition()));
                    view.getContext().startActivity(i); // Starting next activity from view "v"
                }
            });

            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDesc);
            textPrices = itemView.findViewById(R.id.textPrice);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
