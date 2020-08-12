package com.example.recyclerview.bestuichat;

import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recyclerview.R;

import java.util.List;

/**
 * Description： PracticeDemo
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.recyclerview.bestuichat
 * Date: ${date}
 * user: 覃勤 QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHodler> {
    private List<Msg> list;

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {
        Msg msg = list.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.leftlayout.setVisibility(View.VISIBLE);
            holder.rightlayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SEND) {
            holder.leftlayout.setVisibility(View.GONE);
            holder.rightlayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHodler extends RecyclerView.ViewHolder {
        LinearLayout leftlayout;
        LinearLayout rightlayout;
        TextView leftMsg;
        TextView rightMsg;

        public ViewHodler(View itemView) {
            super(itemView);
            leftlayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightlayout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            leftMsg = (TextView) itemView.findViewById(R.id.msg_left);
            rightMsg = (TextView) itemView.findViewById(R.id.msg_right);
        }
    }

    public MsgAdapter(List<Msg> list) {
        this.list = list;
    }


}
