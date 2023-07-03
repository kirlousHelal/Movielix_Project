package com.example.moviepage;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.cinemaVeiwHolder> {
    String[]names;
    int[] images;
    public AdapterRecycle(String[]n,int[]img)
    {
        names=n;
        images=img;
    }



    @NonNull
    @Override
    public cinemaVeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cinema,null,false);
        cinemaVeiwHolder cinemaHolder=new cinemaVeiwHolder(v);
        return cinemaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull cinemaVeiwHolder holder, int position) {
        holder.cinemaImage.setImageResource(images[position]);
        holder.cinemaName.setText(names[position]);

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class cinemaVeiwHolder extends RecyclerView.ViewHolder{
        ImageView cinemaImage;
        TextView cinemaName;
        public cinemaVeiwHolder(@NonNull View itemView) {
            super(itemView);
            cinemaImage=itemView.findViewById(R.id.cinemaImage);
            cinemaName=itemView.findViewById(R.id.cinemaName);

        }
    }
}
