package demo.movieiak.MovieDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import demo.movieiak.Model.ResultTrailer;

/**
 * Created by alhamdulillah on 12/7/16.
 */
public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailAdapter.ViewHolder> {
    ResultTrailer mResultTrailer;
    public MovieDetailAdapter(ResultTrailer resultTrailer) {
        mResultTrailer = resultTrailer;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mResultTrailer.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
