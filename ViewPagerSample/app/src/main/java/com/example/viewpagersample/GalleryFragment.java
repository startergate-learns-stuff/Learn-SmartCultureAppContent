package com.example.viewpagersample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    View rootView;

    EditText msg_et;
    Button send_btn;

    public GalleryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
        msg_et = rootView.findViewById(R.id.msg_et);
        send_btn = rootView.findViewById(R.id.send_btn);
        send_btn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
                Bundle argu = new Bundle();
                argu.putString("msg", msg_et.getText().toString());

                GalleryDetailFragment galleryDetailFragment = new GalleryDetailFragment();

                galleryDetailFragment.setArguments(argu);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.mainFragment, galleryDetailFragment, "DETAIL")
                        .addToBackStack(null).commit();
                break;
        }
    }
}