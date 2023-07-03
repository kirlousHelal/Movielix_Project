package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MovePage1 extends AppCompatActivity {
    GridView gridView;
    MovieAdapter movieAdapter;
    int []movieImageAdapter={R.drawable.mousa,R.drawable.elanswnams,R.drawable.elarf,R.drawable.mesh_ana,R.drawable.karemabelazizz,R.drawable.jungle_cruise1,R.drawable.old1,R.drawable.the_suicide_squad1,R.drawable.paw_patrol,R.drawable.reminiscence1,R.drawable.stillwater1,R.drawable.free_guy1};
    String[]movieNameAdapter={"موسي-Mousa","الانس والنمس","العارف-Alearf","مش انا","البعض لا يذهب للماذون مرتين","Jungle Cruise","Old","The suicide squad","Paw patrol","Reminiscence","Stillwater","Free guy"};
    int[]movieImage={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12};
    movieDatabase moviesDetails=new movieDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        moviedef();
        gridView=findViewById(R.id.movies);
        movieAdapter=new MovieAdapter(this,movieImageAdapter,movieNameAdapter);
        gridView.setAdapter(movieAdapter);
       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               int selectImage=movieImage[position];
               int pos=position;
              String name=moviesDetails.getNmae(position);
               String data=moviesDetails.getData(position);
               String type=moviesDetails.getType(position);
               String describtion=moviesDetails.getDescribtion(position);
               startActivity(new Intent(MovePage1.this, MovePage2.class).putExtra("image",selectImage).putExtra("data",data).putExtra("type",type).putExtra("describtion",describtion).putExtra("name",name).putExtra("postion",pos));

           }
       });
    }

    //@Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i=new Intent(MainActivity.this,MainActivity3.class);
        switch (item.getItemId())
        {
            case R.id.action:
                i.putExtra("typenum",1);
                startActivity(i);
                return true;
            case R.id.comedy:
                i.putExtra("typenum",2);
                startActivity(i);
                return true;
            case R.id.drama:
                i.putExtra("typenum",3);
                startActivity(i);
                return true;
            case R.id.animation:
                i.putExtra("typenum",4);
                startActivity(i);
                return true;

        }
        return false;
    }*/

    public void moviedef()
    {
        moviesDetails.create_movie(0,"موسي-Mousa","11 أغسطس 2021","خيال علمي","تدور الأحداث في إطار خيال علمي، عندما يجد يحيى نفسه وحيدا دون صديق، يقرر اختراع روبوت ويطلق عليه اسم (موسى)، ليصبح صديق له، ولكن الأمور تتطور وتنقلب ضد الجميع.");
        moviesDetails.create_movie(1,"الانس والنمس","12 أغسطس 2021","خيال . كوميدي","في إطار الرعب الكوميدي، يعيش تحسين مع والدته، وشقيقته، ويعمل في بيت الرعب بإحدى الملاهي الترفيهية، في يوم من الأيام يقع له حادث ويتسبب ذلك في تغيير حياته جذريا، حيث يتعرف على الفتاة نرمين، ويتعلق بقلبها، ولكنه يصدم عندما يعلم أنها من قبيلة جن تُدعى (النمس)، وأنهم يسعون إلى زيادة نسلهم عن طريق زواج تحسين ونرمين.");
        moviesDetails.create_movie(2,"العارف-Alearf","14 يوليو 2021 "," ﺗﺸﻮﻳﻖ ﻭﺇﺛﺎﺭﺓ . ﺟﺮﻳﻤﺔ","تدور أحداث الفيلم حول فكرة حرب العقول الأحداث، في وقتنا المعاصر، من خلال قصة يونس الذي يعيش مع زوجته وطفلته الرضيعة في إحدى شقق وسط البلد، ويلجأ إلى سرقة أحد البنوك عن طريق الإنترنت، ويدخل في صراع مع إحدى العصابات الخطيرة.");
        moviesDetails.create_movie(3,"مش انا","23 يونيو 2021","كوميدي","يُصاب حسن بحالة غريبة تفقده السيطرة على يده، فيصبح مع مرور الوقت ضحية العديد من الموقف الصعبة والمحرجة، بينما يرفض كل من حوله تصديق حالته.");
        moviesDetails.create_movie(4,"البعض لا يذهب للمأذون مرتين","30 يوليو 2020","كوميدي","يطرح الفيلم عدة تساؤلات حول تجربة الزواج والصراعات التي يمر الزوجين بها، وذلك من خلال قصة المذيع خالد، ومشاكله الدائمة مع زوجته خبيرة العلاقات الزوجية ثريا، واللذان لا يتفقان في حياتهما أبدا، مما يُشعل النيران بينهما، ولخطأ غير مقصود يُحذف أسماء جميع المتزوجين من النظام الاجتماعي، فيتحول جميع المتزوجين إلى مطلقين، فيتولى صديق خالد عقد لجنة للصلح بين الجميع.");
        moviesDetails.create_movie(5,"Jungle Cruise","28 يوليو 2021 ","مغامرات","الفيلم يقوم على قصة (ديزني لاند) التي تدور أحداثها بحديقة الملاهي، حيث قارب نهري صغير يقل مجموعة من المسافرين عبر غابة مليئة بالحيوانات والزواحف الخطيرة.");
        moviesDetails.create_movie(6,"Old","11 اغسطس 2021","تشويق واثارة","تقرر إحدى اﻷسر أن تقضي عطلتها في إحدى الجُزر الاستوائية، لكن هذه الجزيرة تحوي سرًا مظلمًا، حيث أنها تحوي على قوة غامضة تجعل اﻷشخاص يكبرون في السن كل نصف ساعة.");
        moviesDetails.create_movie(7,"The suicide squad"," 4 اغسطس 2021","مغامرات","يقرر كل من اﻷشرار العتاة هارلي كوين وبلودسبورت وبيسميكر ومعهم مجموعة من المحتالين في سجن بيل ريف أن ينضموا إلى مجموعة مهمات سرية وغامضة في جزيرة بعيدة.");
        moviesDetails.create_movie(8,"Paw patrol","11 أغسطس 2021","رسوم متحركه","في إطار من المغامرات العائلية، ينطلق ريدر والجراء بعد استدعاءهم في مهمة بمدينة المغامرات، حيث يصبح عليهم التدخل ومنع العمدة هامدينجر من تحويل المدينة إلى حالة من الفوضى.");
        moviesDetails.create_movie(9,"Reminiscence"," 18 اغسطس 2021 ","رومانسي","في إطار من الخيال العلمي والتشويق، يكتشف عالم يُدعى نيك بانيستر سرًا علميًا يُمكن البشرية من استعادة الماضي، فيقرر استغلال اكتشافه في البحث عن الحب المفقود.");
        moviesDetails.create_movie(10,"Stillwater","18 اغسطس 2021 ","دراما","بعد تورط ابنته في جريمة قتل مروعة، يسافر أب من أوكلاهوما إلى فرنسا، في خلال رحلة السعي للوقوف بجانبها في الجريمة شديدة الغموض، والبحث عن دليل براءتها من الجريمة.");
        moviesDetails.create_movie(11,"Free guy","11 اغسطس 2021 ","مغامرات .خيال علمي .كوميدي","يعيش جاي في عالم غريب بمهنة صراف في أحد البنوك، وتزداد مخاوفه في الحياة حينما يشك أنه يعيش داخل لعبة فيديو، ليدخل في سباق مع الزمن لإنقاذ لعبة الفيديو قبل قيام مطوريها بإغلاقها.");



    }
}