package com.roopre.simpleboard.Fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roopre.simpleboard.BoardVO;
import com.roopre.simpleboard.R;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private final List<BoardVO> mValues;

    public BoardAdapter(List<BoardVO> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        BoardVO bVO = mValues.get(position);

        holder.nickname_tv.setText(bVO.getNickname());
        holder.time_tv.setText(bVO.getCrt_dt());
        holder.title_tv.setText(bVO.getTitle());
        holder.content_tv.setText(bVO.getContent());
        holder.reply_tv.setText(bVO.getReply_count());
        holder.like_tv.setText(bVO.getLike_count());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout parent_cl;
        ImageView profile_iv;
        TextView nickname_tv, time_tv, title_tv, content_tv;
        TextView reply_tv, like_tv;

        public ViewHolder(View view) {
            super(view);

            parent_cl = view.findViewById(R.id.parent_cl);
            profile_iv = view.findViewById(R.id.profile_iv);
            nickname_tv = view.findViewById(R.id.nickname_tv);
            time_tv = view.findViewById(R.id.time_tv);
            title_tv = view.findViewById(R.id.title_tv);
            content_tv = view.findViewById(R.id.content_tv);

            reply_tv = view.findViewById(R.id.reply_tv);
            like_tv = view.findViewById(R.id.like_tv);
        }

    }
}