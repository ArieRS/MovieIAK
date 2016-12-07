package demo.movieiak.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alhamdulillah on 12/7/16.
 */

public class ResultTrailer {
    @SerializedName("results")
    List<Trailer> results;

    public List<Trailer> getResults() {
        return results;
    }
}
