package com.example.viewpagersample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SlideShowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlideShowFragment extends Fragment {

    View rootView;

    public SlideShowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SlideShowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SlideShowFragment newInstance(String param1, String param2) {
        SlideShowFragment fragment = new SlideShowFragment();
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
        rootView = inflater.inflate(R.layout.fragment_slide_show, container, false);
        return rootView;
    }
}