package com.roopre.simpleboard.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.roopre.simpleboard.R;

import androidx.fragment.app.Fragment;

public class PopBoardFragment extends Fragment implements View.OnClickListener {

    View rootView;
    EditText msg_et;
    Button send_btn;

    public PopBoardFragment() {
    }


    public static PopBoardFragment newInstance(String param1, String param2) {
        PopBoardFragment fragment = new PopBoardFragment();
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
        rootView = inflater.inflate(R.layout.fragment_pop_board, container, false);;

        msg_et = rootView.findViewById(R.id.msg_et);
        send_btn = rootView.findViewById(R.id.send_btn);

        send_btn.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.send_btn:
                // 원하는 데이터를 담을 객체
                Bundle argu = new Bundle();
                argu.putString("msg", msg_et.getText().toString());

                // 이동할 Fragment 선언
                ChatFragment galleryDetailFragment = new ChatFragment();

                // 이동할 Fragment 에 데이터 객체 담기
                galleryDetailFragment.setArguments(argu);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.mainFragment, galleryDetailFragment, "GALLERYDETAIL")
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
