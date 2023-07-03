package com.example.moviepage;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
public class cinema_adapter extends ArrayAdapter {
    Context adaper_context;
    int adapterresource;
    cinemas[] adptercinema;
    Movies[] adptermovies;
    int id_page;
    public cinema_adapter(@NonNull Context context, int resource, @NonNull cinemas[] dataofcinema,int id) {
        super(context, resource, dataofcinema);
        adaper_context=context;
        adapterresource=resource;
        adptercinema=dataofcinema;
        id_page=id;
    }
    public  cinema_adapter(Context context,int resource,Movies[]dataofmovie,int id)
    {
        super(context,resource,dataofmovie);
        adaper_context=context;
        adapterresource=resource;
        adptermovies=dataofmovie;
        id_page =id;

    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        LayoutInflater rowinflater=LayoutInflater.from(adaper_context);
        row=rowinflater.inflate(adapterresource,parent,false);
        //cinema
        ImageView image=(ImageView) row.findViewById(R.id.image1);
        TextView  name=(TextView)row.findViewById(R.id.textView1);
        TextView  movie=(TextView)row.findViewById(R.id.textView2);
        //movies
        ImageView imagemovie=row.findViewById(R.id.imageView3);
        TextView type=row.findViewById(R.id.textView6);
        TextView time1=row.findViewById(R.id.textView3);
        TextView time2=row.findViewById(R.id.textView5);
        TextView name_of_movie=row.findViewById(R.id.textView7);
        if(id_page==1)
        {
            cinemas cinema=adptercinema[position];
            name.setText(cinema.name_of_cinema);
            movie.setText(cinema.num_of_movie);
            int imagr_id=adaper_context.getResources().getIdentifier(cinema.image,"drawable",adaper_context.getPackageName());
            image.setImageResource(imagr_id);
        }
        else if(id_page==2)
        {
            Movies movies=adptermovies[position];
            imagemovie.setImageResource(movies.Image);
            type.setText(movies.category);
            time1.setText(movies.time1);
            time2.setText(movies.time2);
            name_of_movie.setText(movies.name);

        }



        return row;
    }
}
