package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CinemaPage2 extends AppCompatActivity {
    cinema_adapter adapter;
    //movies
    Movies my_movie1=new Movies(R.drawable.film1,"Old","50 L.E 05:00 |06:30","70 L.E 07:00|08:30","Thriller/Horror");
    Movies my_movie2=new Movies(R.drawable.film2,"Still Water","40 L.E 04:00 |06:00","50 L.E 09:00|11:00","Drama/Suspense");
    Movies my_movie3=new Movies(R.drawable.film3,"البعض لا يذهب للمأذون مرتين","80 L.E 05:00 |06:30","70 L.E 03:00|04:30","Comedy/Romance");
    Movies my_movie4=new Movies(R.drawable.film4,"موسى","110 L.E 05:00 |07:30","120 L.E 08:00|10:30","Action/Drama");
    Movies my_movie5=new Movies(R.drawable.film5,"Reminiscence","50 L.E 05:00 |06:30","70 L.E 07:00|08:30","Romance/Mystery");
    Movies my_movie6=new Movies(R.drawable.film6,"Jungle Cruise","95 L.E 05:00 |06:30","135 L.E 07:00|08:30","Action/Comedy");
    Movies my_movie7=new Movies(R.drawable.film7,"Free Guy","35 L.E 06:00 |07:00","45 L.E 07:00|08:30","Action/Comedy");
    Movies my_movie8=new Movies(R.drawable.film8,"The Suicide Squad","40 L.E 08:00 |09:30","50 L.E 10:00|11:30","Adventure/Action");
    Movies my_movie9=new Movies(R.drawable.film9,"PAW Patrol","50 L.E 05:00 |06:30","70 L.E 07:00|08:30","Animation/Comedy");
    Movies my_movie10=new Movies(R.drawable.film10,"مش انا ","120 L.E 06:00 |08:30","130 L.E 09:00|11:30","Comedy/Romance");
    Movies my_movie11=new Movies(R.drawable.film11,"العارف","120 L.E 06:00 |08:30","35 L.E 07:00|08:30","Action/Thriller");
    Movies my_movie12=new Movies(R.drawable.film12,"الانس والنمس","40 L.E 04:00 |06:00","50 L.E 07:00 |09:00","Comedy/Fantasy");
    //cinemamov
    Movies[] cinema1={my_movie11,my_movie12,my_movie4};
    Movies[] cinema2={my_movie3,my_movie10,my_movie11,my_movie6,my_movie12,my_movie8,my_movie1,my_movie4,my_movie5,my_movie9,my_movie2,my_movie7};
    Movies[] cinema3={my_movie10,my_movie11,my_movie12,my_movie4,my_movie5};
    Movies[] cinema4={my_movie3};
    Movies[] cinema5={my_movie10,my_movie11,my_movie4,my_movie12};

    int xml_file=R.layout.design_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        TextView adress1=(TextView)findViewById(R.id.txt_adress);
        ImageView image1=(ImageView)findViewById(R.id.imageView);
        ListView mylist=(ListView)findViewById(R.id.list_1);
        Intent intent=this.getIntent();
        String adress2=intent.getStringExtra("adress");
        int image2=intent.getIntExtra("image_id",R.drawable.cinema1);
        int selectCinema=intent.getIntExtra("select",0);
        adress1.setText(adress2);
        image1.setImageResource(image2);
        // functio
        cinemaMove(selectCinema);
        mylist.setAdapter(adapter);

    }
    public void cinemaMove(int num)
    {
        switch (num)
        {
            case 0:
                adapter = new cinema_adapter(getApplicationContext(), xml_file, cinema1, 2);
                break;
            case 1:
                adapter = new cinema_adapter(getApplicationContext(), xml_file, cinema2, 2);
                break;
            case 2:
                adapter = new cinema_adapter(getApplicationContext(), xml_file, cinema3, 2);
                break;
            case 3:
                adapter = new cinema_adapter(getApplicationContext(), xml_file, cinema4, 2);
                break;
            case 4:
                adapter = new cinema_adapter(getApplicationContext(), xml_file, cinema5, 2);
                break;
        }
    }

}