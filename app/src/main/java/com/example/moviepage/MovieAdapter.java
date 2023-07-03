package com.example.moviepage;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MovieAdapter extends BaseAdapter {
    int[]movieImage;
    String[]movieName;
    Context page;
    int select;

    MovieAdapter(Context context,int[]image,String[]name)
    {

        page=context;
        movieImage=image;
        movieName=name;
        select=1;
    }
    MovieAdapter(Context context,int[]image)
    {
        page=context;
        movieImage=image;
        select=2;
    }
    @Override
    public int getCount() {
        return movieImage.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view1= LayoutInflater.from(page).inflate(R.layout.item11,null);
        ImageView imageView=view1.findViewById(R.id.image_grade);
        TextView textView=view1.findViewById(R.id.textView2);
        imageView.setImageResource(movieImage[position]);
        if(select==1)
        {
            textView.setText(movieName[position]);
            if(movieName[position].length()>15&&movieName[position].length()<=19)
            {
                textView.setTextSize(17);
            }
            else if(movieName[position].length()>=20)
            {
                textView.setTextSize(14);
            }
        }
        else if(select==2)
            textView.setText("");


        return view1;
    }
}
