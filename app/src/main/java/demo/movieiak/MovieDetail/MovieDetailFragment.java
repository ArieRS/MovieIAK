package demo.movieiak.MovieDetail;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import demo.movieiak.Model.Movie;
import demo.movieiak.Model.ResultTrailer;
import demo.movieiak.R;

public class MovieDetailFragment extends Fragment {
    Movie mMovie;
    TextView tvTitle, tvYear, tvLong, tvRating, tvDescription, tvTrailer, tvReview;
    Button btnMarkAsFavorite;
    ImageView imgDetail;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    public MovieDetailFragment() {}

    public static MovieDetailFragment newIntance() {
        return new MovieDetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mMovie = arguments.getParcelable("movie");
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        InitialiseView(view);
        return view;
    }

    private void InitialiseView(View view) {
        tvTitle = (TextView) view.findViewById(R.id.title);
        imgDetail = (ImageView) view.findViewById(R.id.imgDetail);
        tvYear = (TextView) view.findViewById(R.id.tvYear);
        tvLong = (TextView) view.findViewById(R.id.tvLong);
        tvRating = (TextView) view.findViewById(R.id.tvRating);
        btnMarkAsFavorite = (Button) view.findViewById(R.id.btMarkAsFavorite);
        tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        tvTrailer = (TextView) view.findViewById(R.id.textViewTrailer);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTrailer);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));


        tvReview = (TextView) view.findViewById(R.id.tvReview);
    }

    class getTrailerMovie extends AsyncTask<String,Void,ResultTrailer>{
        @Override
        protected ResultTrailer doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(ResultTrailer resultTrailer) {
            super.onPostExecute(resultTrailer);
            mAdapter = new MovieDetailAdapter(resultTrailer);
            mRecyclerView.setAdapter(mAdapter);
        }
    };
    class getReview extends AsyncTask<String, Void, Void>{
        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    };

}
