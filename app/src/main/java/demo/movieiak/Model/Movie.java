package demo.movieiak.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alhamdulillah on 12/3/16.
 */

public class Movie implements Parcelable{
    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("adult")
    boolean adult;
    @SerializedName("overview")
    String overview;
    @SerializedName("release_date")
    String realeaseDate;
    @SerializedName("id")
    private String id;
    @SerializedName("original_title")
    private String title; // original_title
    @SerializedName("backdrop_path")
    private String backdrop_path; // backdrop_path
    @SerializedName("vote_average")
    private String vote_average; // vote_average

    public Movie() {
    }

    public Movie(Movie mMovie) {
        this.posterPath = mMovie.getPosterPath();
        this.adult = mMovie.isAdult();
        this.overview = mMovie.getOverview();
        this.realeaseDate = mMovie.getRealeaseDate();
        this.id = mMovie.getId();
        this.title = mMovie.getTitle();
        this.backdrop_path = mMovie.getBackdrop_path();
        this.vote_average = mMovie.getVote_average();
    }

    protected Movie(Parcel in) {
        posterPath = in.readString();
        adult = in.readByte() != 0;
        overview = in.readString();
        realeaseDate = in.readString();
        id = in.readString();
        title = in.readString();
        backdrop_path = in.readString();
        vote_average = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRealeaseDate() {
        return realeaseDate;
    }

    public void setRealeaseDate(String realeaseDate) {
        this.realeaseDate = realeaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    ///generate result
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
        parcel.writeString(overview);
        parcel.writeString(realeaseDate);
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(backdrop_path);
        parcel.writeString(vote_average);
//        parcel.writeString(getPosterPath());
//        parcel.writeString(getOverview());
//        parcel.writeString(getRealeaseDate());
//        parcel.writeString(getId());
//        parcel.writeString(getTitle());
//        parcel.writeString(getBackdrop_path());
//        parcel.writeString(getVote_average());
    }
}
