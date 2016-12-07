package demo.movieiak.Movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import demo.movieiak.General;
import demo.movieiak.Model.Movie;
import demo.movieiak.MovieDetail.MovieDetailActivity;
import demo.movieiak.R;

public class MovieActivity extends AppCompatActivity implements MoviewFragment.OnFragmentInteractionListener{
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        MoviewFragment moviewFragment = (MoviewFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (moviewFragment == null){
            moviewFragment = MoviewFragment.newInstance();
            FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, moviewFragment);
            transaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("movie", movie);
        intent.putExtra(General.POSTER_PATH,movie.getPosterPath());
        intent.putExtra(General.OVERVIEW,movie.getOverview());
        intent.putExtra(General.ID,movie.getId());
        intent.putExtra(General.VOTE_AVERAGE,movie.getVote_average());
        intent.putExtra(General.RELEASE_DATE,movie.getRealeaseDate());
        intent.putExtra(General.BACKDROP_PATH,movie.getBackdrop_path());
        intent.putExtra(General.ORIGINAL_TITLE,movie.getTitle());
        startActivity(intent);
    }
}
