package demo.movieiak.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alhamdulillah on 12/7/16.
 */

public class Trailer {
    @SerializedName("key")
    String key;
    @SerializedName("name")
    String name;
    @SerializedName("site")
    String site;

    public Trailer(String key, String name, String site) {
        this.key = key;
        this.name = name;
        this.site = site;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }
}
