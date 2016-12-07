package demo.movieiak.MovieDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import demo.movieiak.General;
import demo.movieiak.Model.Movie;
import demo.movieiak.R;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        Movie movie  = new Movie();
        movie.setPosterPath(intent.getStringExtra(General.POSTER_PATH));
        movie.setOverview(intent.getStringExtra(General.OVERVIEW));
        movie.setId(intent.getStringExtra(General.ID));
        movie.setVote_average(intent.getStringExtra(General.VOTE_AVERAGE));
        movie.setRealeaseDate(intent.getStringExtra(General.RELEASE_DATE));
        movie.setBackdrop_path(intent.getStringExtra(General.BACKDROP_PATH));
        movie.setTitle(intent.getStringExtra(General.ORIGINAL_TITLE));

        MovieDetailFragment movieDetailFragment = (MovieDetailFragment) getSupportFragmentManager().findFragmentById(R.id.movieDetailFrame);
        if (movieDetailFragment==null){
            movieDetailFragment = MovieDetailFragment.newIntance();
            Bundle bundle = new Bundle();
            bundle.putParcelable("movie",
                    movie);
            movieDetailFragment.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.movieDetailFrame, movieDetailFragment);
            transaction.commit();
        }

    }
}
