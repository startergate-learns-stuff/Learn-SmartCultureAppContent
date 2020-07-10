package com.roopre.simpleboard.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.roopre.simpleboard.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatRoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatRoomFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "ChatRoomFragment";
    EditText chatroom_et;
    Button enter_btn;

    public ChatRoomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatRoomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatRoomFragment newInstance(String param1, String param2) {
        ChatRoomFragment fragment = new ChatRoomFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chat_room, container, false);
        chatroom_et = rootView.findViewById(R.id.chatroom_et);
        enter_btn = rootView.findViewById(R.id.enter_btn);
        enter_btn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter_btn:
                if (chatroom_et.getText().toString().trim().length() > 0) {
                    Log.d(TAG, "입장 처리");

                    Bundle argu = new Bundle();
                    argu.putString("chatroom", chatroom_et.getText().toString());

                    ChatMsgFragment chatMsgFragment = new ChatMsgFragment();
                    chatMsgFragment.setArguments(argu);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                            .replace(R.id.mainFragment, chatMsgFragment, "CHATMSG")
                            .addToBackStack(null)
                            .commit();
                } else {
                    Toast.makeText(getActivity(), "채팅방 이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}