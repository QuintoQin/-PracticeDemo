package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Description： HomeWork
 * Copyright (c)
 * This program is protected by copyright laws.
 * package: com.example.recyclerview
 * Date: ${date}
 * user: 覃勤 QuintoQin
 *
 * @author 覃勤
 * @version : 1.0
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Item> list;
    Context context;


    public Adapter(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Item item = list.get(position);
                Toast.makeText(v.getContext(), "you click view" + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Item item = list.get(position);
                Toast.makeText(v.getContext(), "you click view" + item.getImageRes(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.clickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(v.getContext(), "you click item" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = list.get(position);
        Picasso.with(context).load(item.getImageRes()).into(holder.imageView);
        holder.textView.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        //点击事件view
        View clickView;

        public ViewHolder(View itemView) {
            super(itemView);
            clickView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.iv);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
