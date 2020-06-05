package com.example.viewpagersample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GalleryDetailFragment extends Fragment implements View.OnClickListener {

    View rootView;

    TextView msg_tv;

    public GalleryDetailFragment() {

    }

    public static GalleryDetailFragment newInstance(String param1, String param2) {
        GalleryDetailFragment fragment = new GalleryDetailFragment();
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
        rootView = inflater.inflate(R.layout.fragment_gallery_detail, container, false);
        msg_tv = rootView.findViewById(R.id.msg_tv);
        msg_tv.setText(getArguments().getString("msg"));
        return rootView;
    }

    @Override
    public void onClick(View v) {
    }
}