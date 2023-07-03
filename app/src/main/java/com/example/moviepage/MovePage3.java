package com.example.moviepage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MovePage3 extends AppCompatActivity {
    GridView gridView2;
    MovieAdapter movieAdapter2;
    int[]action={R.drawable.action1,R.drawable.action2,R.drawable.action3,R.drawable.action4,R.drawable.action5,R.drawable.action6,R.drawable.action7,R.drawable.action8,R.drawable.action9,R.drawable.action10};
    int[]comdey={R.drawable.comedy1,R.drawable.comedy2,R.drawable.comedy3,R.drawable.comedy4,R.drawable.comedy5,R.drawable.comedy6,R.drawable.comedy7,R.drawable.comedy8,R.drawable.comedy9,R.drawable.comedy10,};
    int[]drama={R.drawable.drama1,R.drawable.drama2,R.drawable.drama3,R.drawable.drama4,R.drawable.drama5,R.drawable.drama6,R.drawable.drama7,R.drawable.drama8,R.drawable.drama9,R.drawable.drama10,};
    int[]anmation={R.drawable.carton1,R.drawable.carton2,R.drawable.carton3,R.drawable.carton4,R.drawable.carton5,R.drawable.carton6,R.drawable.carton7,R.drawable.carton8,R.drawable.carton9,R.drawable.carton10,};
    String[] Url;
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gridView2=findViewById(R.id.onlinemovie);
        Intent i=getIntent();
        if(i.getExtras()!=null)
        {
            type=i.getIntExtra("typenum",0);
        }

        selectType(type);
        gridView2.setAdapter(movieAdapter2);
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goUrl(Url[position]);
            }
        });

    }
    public void selectType(int num)
    {
        switch (num)
        {
            case 1:
                movieAdapter2=new MovieAdapter(this,action);
                Url= new String[]{"https://been.egybest.run/series/al-ekhteyar/", "https://been.egybest.run/movie/casablanca-2019/", "https://been.egybest.run/movie/hamlet-far3on-2019/", "https://been.egybest.run/movie/welad-rezk-2-2019/", "https://been.egybest.run/movie/el-diesel-2018/","https://been.egybest.run/movie/al-khaleya-2017/?ref=movies-p1","https://been.egybest.run/movie/horob-edterary-2017/?ref=movies-p2","https://been.egybest.run/movie/omar-el-azraq-2017/?ref=movies-p2","https://been.egybest.run/movie/al-haram-al-rabe3-2016/?ref=movies-p2","https://been.egybest.run/movie/shad-agza2-2015/?ref=movies-p2"};
                break;
            case 2:
                movieAdapter2=new MovieAdapter(this,comdey);
                Url=new String[]{"https://been.egybest.run/movie/dido-2021/","https://been.egybest.run/movie/waafet-reggala-2021/","https://been.egybest.run/movie/less-baghdad-2020/","https://been.egybest.run/movie/el-khetta-el-aayma-2020/","https://been.egybest.run/movie/khayal-ma2ata-2019/","https://been.egybest.run/movie/qarmat-bitmarmat-2019/?ref=movies-p2","https://been.egybest.run/movie/saeat-reda-2019/?ref=movies-p2","https://been.egybest.run/movie/sab3-el-bromba-2019/?ref=movies-p2","https://been.egybest.run/movie/al-badla-2018/?ref=movies-p3","https://been.egybest.run/movie/nady-al-regal-al-serry-2019/?ref=movies-p2",};
                break;
            case 3:
                movieAdapter2=new MovieAdapter(this,drama);
                Url=new String[]{"https://been.egybest.run/movie/zenzana-7-2020/","https://been.egybest.run/movie/al-hareth-2020/","https://been.egybest.run/movie/sundooq-al-dunya-2020/","https://been.egybest.run/movie/saheb-el-maqam-2020/","https://been.egybest.run/movie/al-kenz-2-2019/","https://been.egybest.run/movie/al-deef-2019/","https://been.egybest.run/movie/bany-adam-2018/?ref=movies-p4","https://been.egybest.run/movie/al-aslyeen-2017/?ref=movies-p4","https://been.egybest.run/movie/sheikh-jackson-2017/?ref=movies-p4","https://been.egybest.run/movie/al-kenz-2017/?ref=movies-p5",};
                break;
            case 4:
                movieAdapter2=new MovieAdapter(this,anmation);
                Url=new String[]{"https://been.egybest.run/movie/the-boss-baby-family-business-2021/?ref=search-p1","https://been.egybest.run/movie/felix-and-the-hidden-treasure-2021/","https://been.egybest.run/movie/luca-2021/","https://been.egybest.run/movie/tom-and-jerry-2021/","https://been.egybest.run/movie/the-loud-house-2021/?ref=movies-p1","https://been.egybest.run/movie/teen-titans-go-see-space-jam-2021/?ref=movies-p1","https://been.egybest.run/movie/the-spongebob-movie-sponge-on-the-run-2020/?ref=movies-p8","https://been.egybest.run/movie/peter-rabbit-2-2021/?ref=movies-p2","https://been.egybest.run/movie/scoob-2020/?ref=movies-p8","https://been.egybest.run/movie/frozen-ii-2019/?ref=movies-p13",};
                break;
        }
    }
    public void goUrl(String adress)
    {
        Uri uri= Uri.parse(adress);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}