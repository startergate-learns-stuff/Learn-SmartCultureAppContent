package com.roopre.simpleboard.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.roopre.simpleboard.R;

import androidx.fragment.app.Fragment;

public class BoardListFragment extends Fragment implements View.OnClickListener {

    View rootView;

    Button free_btn, humor_btn, life_btn, job_btn;

    public BoardListFragment() {
        // Required empty public constructor
    }

    public static BoardListFragment newInstance(String param1, String param2) {
        BoardListFragment fragment = new BoardListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_board_list, container, false);;

        free_btn = rootView.findViewById(R.id.free_btn);
        humor_btn = rootView.findViewById(R.id.humor_btn);
        life_btn = rootView.findViewById(R.id.life_btn);
        job_btn = rootView.findViewById(R.id.job_btn);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        Bundle argu = new Bundle();
        BoardFragment boardFragment = new BoardFragment();

        switch (v.getId()) {
            case R.id.free_btn:
                argu.putString("type", "자유");

                boardFragment.setArguments(argu);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.mainFragment, boardFragment, "BOARD")
                        .addToBackStack(null)
                        .commit();
            case R.id.humor_btn:
                argu.putString("type", "유머");

                boardFragment.setArguments(argu);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.mainFragment, boardFragment, "BOARD")
                        .addToBackStack(null)
                        .commit();
            case R.id.life_btn:
                argu.putString("type", "일상");

                boardFragment.setArguments(argu);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.mainFragment, boardFragment, "BOARD")
                        .addToBackStack(null)
                        .commit();
            case R.id.job_btn:
                argu.putString("type", "취업");

                boardFragment.setArguments(argu);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.mainFragment, boardFragment, "BOARD")
                        .addToBackStack(null)
                        .commit();
        }
    }
}
