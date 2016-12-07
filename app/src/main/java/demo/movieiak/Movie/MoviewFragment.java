package demo.movieiak.Movie;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import demo.movieiak.Model.Movie;
import demo.movieiak.Model.ResultMovie;
import demo.movieiak.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MoviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    Context mContext;

    public MoviewFragment() {
    }
    public static MoviewFragment newInstance() {
        return new MoviewFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_moview, container, false);

        mContext = getActivity().getApplicationContext();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerMovie);
        mLayoutManager = new GridLayoutManager(mContext,2);

        mRecyclerView.setLayoutManager(mLayoutManager);

        ResultMovie hasil = new ResultMovie();
        //mAdapter = new MyAdapter(hasil,mListener);
        //mRecyclerView.setAdapter(mAdapter);

        new FecthMovieData().execute();
        return view;
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoviewFragment newInstance(String param1, String param2) {
        MoviewFragment fragment = new MoviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Movie movie);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private class FecthMovieData extends AsyncTask<Void, Void, ResultMovie> {
        ResultMovie resultMovie = new ResultMovie();

        @Override
        protected ResultMovie doInBackground(Void... voids) {
            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String forecastJsonStr = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are available at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                String linkURL = "http://api.themoviedb.org/3/movie/popular?api_key=a57ad9ba5b3888623524f0113a60c3ac";
                URL url = new URL(linkURL);

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    forecastJsonStr = null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    forecastJsonStr = null;
                }
                //data json akan ada disini
                forecastJsonStr = buffer.toString();
//                for (Movie data : resultMovie.getDataMovies()) {
//                    Log.i("hasil dari server : ", data.getPosterPath());
//                }

            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attempting
                // to parse it.
                forecastJsonStr = null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("PlaceholderFragment", "Error closing stream", e);
                    }
                }
            }

            if (forecastJsonStr!=null){
                Gson gson = new Gson();
                resultMovie = gson.fromJson(forecastJsonStr, ResultMovie.class);
                return resultMovie;
            }else  return null;

        }

        @Override
        protected void onPostExecute(ResultMovie resultMovie) {
            mAdapter = new MyAdapter(resultMovie, mListener);
            //mAdapter.notifyDataSetChanged();
            mRecyclerView.setAdapter(mAdapter);
            super.onPostExecute(resultMovie);
        }
    }
}
