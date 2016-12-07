package demo.movieiak.Movie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import demo.movieiak.Model.Movie;
import demo.movieiak.Model.ResultMovie;
import demo.movieiak.R;

/**
 * Created by alhamdulillah on 12/3/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.TestHolder> {
    ResultMovie hasil=null;
    MoviewFragment.OnFragmentInteractionListener mListener;

    public MyAdapter(ResultMovie hasil, MoviewFragment.OnFragmentInteractionListener listener) {
        this.hasil = hasil;
        mListener = listener;
    }

    @Override
    public TestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_grid_layout, parent, false);
        TestHolder holder = new TestHolder(mView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final TestHolder holder, int position) {
        //ambil list dari movie
        final Movie movie = new Movie(hasil.getDataMovies().get(position));
        Glide.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185" + movie.getPosterPath())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(movie);
            }
        });
        //ini menggunakan picasso
//        Picasso.with(holder.itemView.getContext())
//                .load(movie.getPosterPath())
//                .into(holder.image);
    }

    @Override
    public int getItemCount() {
//        if ((hasil==null)||(hasil.getDataMovies()==null)){
//            return  0;
//        } else {
//            return 2;
//        }
        return 2;

    }
    //hasil.getDataMovies().size();

    public class TestHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public TestHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageMovie);
        }
    }

}
