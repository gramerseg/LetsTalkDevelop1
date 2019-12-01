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
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> data;
    private List<Integer> imag;

    Adapter(Context context, ArrayList<String> data, ArrayList<Integer> imag) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.imag = imag;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Bind the textview with data received
        String title = data.get(position);
        holder.textTitle.setText(title);
        //Similarly you can set new image/description for each card
        holder.imageView.setImageResource(imag.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle,textDescription;
        ImageView imageView;

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
                    view.getContext().startActivity(i); // Starting next activity from view "v"
                }
            });

            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDesc);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}