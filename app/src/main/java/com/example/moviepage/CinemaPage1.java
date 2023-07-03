package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CinemaPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        String[] adrres={"Abdel Aziz El shennawy st.,Inside Massah Hotel, Naser \n City, Cairo",
                "Inside Americana Plaza Mall, 6th of October, Giza",
                "12 Emad El Din st,Downtown,Cairo",
                "17 Al Alfi st,Downtown,Cairo ",
                "113 Pyramids Rd, Giza"};
        int[] image_id={R.drawable.cinema1,R.drawable.cinema2,R.drawable.cinema3,R.drawable.cinema4,R.drawable.cinema5};

        ListView listView=(ListView) findViewById(R.id.list_1);
        cinemas cinema_list1=new cinemas("cinema1","Al Massah","3 movies");
        cinemas cinema_list2=new cinemas("cinema2","Plaza Cinema","12 movies");
        cinemas cinema_list3=new cinemas("cinema3","Cosmos","5 movies");
        cinemas cinema_list4=new cinemas("cinema4","Diana","1 movie");
        cinemas cinema_list5=new cinemas("cinema5","El Haram","4 movies");
        cinemas[] cinemalist={cinema_list1,cinema_list2,cinema_list3,cinema_list4,cinema_list5};
        int xml_file=R.layout.design_cinema;
        cinema_adapter cin_adapt=new cinema_adapter(getApplicationContext(),xml_file,cinemalist,1);
        listView.setAdapter(cin_adapt);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(CinemaPage1.this, CinemaPage2.class);
                i.putExtra("adress",adrres[position]);
                i.putExtra("image_id",image_id[position]);
                i.putExtra("select",position);

                startActivity(i);
            }
        });

    }
}