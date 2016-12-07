package demo.movieiak.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alhamdulillah on 12/3/16.
 */

public class ResultMovie {
    @SerializedName("results")
    List<Movie> dataMovies;

    public List<Movie> getDataMovies() {
        return dataMovies;
    }

    public void setDataMovies(List<Movie> dataMovies) {
        this.dataMovies = dataMovies;
    }
}
