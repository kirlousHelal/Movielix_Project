package com.example.moviepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovePage2 extends AppCompatActivity {
    ImageView imageView,image1,image2,image3,image4;
    TextView datamovie,typemovie,describtionmovie,nameMovie,textCinema1,textCinema2,textCinema3,textCinema4;
    int[] cinemaImage={R.drawable.cinema1,R.drawable.cinema2,R.drawable.cinema3,R.drawable.cinema4,R.drawable.cinema5};
    String[] cinemaName={"Al Massah","Plaza Cinema","Cosmos","Diana","El Haram",};
    RecyclerView rv;
    int postion;
    AdapterRecycle adapterRecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView=findViewById(R.id.imageMovie);
        rv=findViewById(R.id.recycleCinema);

       /* image1=findViewById(R.id.cinema1);
        image2=findViewById(R.id.cinema2);
        image3=findViewById(R.id.cinema3);
        image4=findViewById(R.id.cinema4);
        textCinema1=findViewById(R.id.cin1);
        textCinema2=findViewById(R.id.cin2);
        textCinema3=findViewById(R.id.cin3);
        textCinema4=findViewById(R.id.cin4);*/
        datamovie=findViewById(R.id.textView5);
        typemovie=findViewById(R.id.textView7);
        describtionmovie=findViewById(R.id.textView8);
        nameMovie=findViewById(R.id.textView4);
        Intent i=getIntent() ;
        if(i.getExtras()!=null)
        {
            int selectImage=i.getIntExtra("image",0);
            String data=i.getStringExtra("data");
            String type=i.getStringExtra("type");
            String describtion=i.getStringExtra("describtion");
            String name=i.getStringExtra("name");
            postion=i.getIntExtra("postion",0);
          //  cinema(1);

            imageView.setImageResource(selectImage);
            datamovie.setText(data);
            typemovie.setText(type);
            describtionmovie.setText(describtion);
            nameMovie.setText(name);
        }
        cinema(postion);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MovePage2.this, LinearLayoutManager.HORIZONTAL,false);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapterRecycle);
    }
    public void cinema(int numMovie)
    {
        String[]name;
        int[]image;
        switch (numMovie)
        {
            case 0:
            case 1:
            case 2:
                name= new String[]{cinemaName[0], cinemaName[1], cinemaName[2], cinemaName[4],};
                image=new int[]{cinemaImage[0],cinemaImage[1],cinemaImage[2],cinemaImage[4],};
                adapterRecycle=new AdapterRecycle(name,image);
                break;
            case 3:
                name=new String[]{cinemaName[1],cinemaName[2],cinemaName[4],};
                image=new int[]{cinemaImage[1],cinemaImage[2],cinemaImage[4],};
                adapterRecycle=new AdapterRecycle(name,image);
                break;
            case 4:
                name=new String[]{cinemaName[1],cinemaName[3],};
                image=new int[]{cinemaImage[1],cinemaImage[3],};
                adapterRecycle=new AdapterRecycle(name,image);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                name=new String[]{cinemaName[1]};
                image=new int[]{cinemaImage[1]};
                adapterRecycle=new AdapterRecycle(name,image);
                break;
            case 9:
                name=new String[]{cinemaName[1],cinemaName[2],};
                image=new int[]{cinemaImage[1],cinemaImage[2],};
                adapterRecycle=new AdapterRecycle(name,image);
                break;
            case 10:
            case 11:
                name=new String[]{cinemaName[1]};
                image=new int[]{cinemaImage[1]};
                adapterRecycle=new AdapterRecycle(name,image);
                break;




        }
    }
}