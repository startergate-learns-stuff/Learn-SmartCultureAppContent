package com.roopre.simpleboard.Fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.roopre.simpleboard.BoardVO;
import com.roopre.simpleboard.Public.Se_Application;
import com.roopre.simpleboard.R;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A fragment representing a list of Items.
 */
public class BoardFragment extends Fragment {

    private final String TAG = getClass().getSimpleName();
    String board_type = "";
    RecyclerView rv;
    List<BoardVO> boardList = new ArrayList<>();

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BoardFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BoardFragment newInstance(String type) {
        BoardFragment fragment = new BoardFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            board_type = getArguments().getString("type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            rv = (RecyclerView) view;

            new LoadBoard().execute();
        }
        return view;
    }

    class LoadBoard extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {

            String result = null;

            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme("http")
                    .host(Se_Application.Server_URL)
                    .addPathSegment("load_board_list.php")
                    .addQueryParameter("type", board_type)
                    .build();
            try {
                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                Response response = client.newCall(request).execute();
                result = response.body().string();
                //Log.d(TAG, "doInBackground = "+result);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d(TAG, "s = "+s);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<BoardVO>>() {}.getType();
            boardList = gson.fromJson(s, listType);

            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv.setAdapter(new BoardAdapter(boardList));


        }
    }
}