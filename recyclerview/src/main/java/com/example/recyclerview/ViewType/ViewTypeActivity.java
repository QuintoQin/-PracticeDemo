package com.example.recyclerview.ViewType;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class ViewTypeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_type);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.rlView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.addItemDecoration(new SpacesItemDe);
        mRecyclerView.setAdapter(new ViewTypeAdapter());
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            mDatas.add("位置是" + i);
        }
    }

    class ViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public static final int ONE_ITEM = 1;
        public static final int TWO_ITEM = 2;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater mInflater = LayoutInflater.from(ViewTypeActivity.this);
            RecyclerView.ViewHolder holder = null;
            if (ONE_ITEM == viewType) {
                View v = mInflater.inflate(R.layout.item1, parent, false);
                holder = new OneViewHolder(v);
            } else if (TWO_ITEM == viewType) {
                View v = mInflater.inflate(R.layout.item2, parent, false);
                holder = new TwoViewHolder(v);
            }
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof OneViewHolder) {
                ((OneViewHolder) holder).tv.setText(mDatas.get(position));
            } else if (holder instanceof TwoViewHolder) {
                ((TwoViewHolder) holder).tv1.setText(mDatas.get(position));
                 ((TwoViewHolder) holder).tv2.setText(mDatas.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 3 == 0) {
                return TWO_ITEM;
            } else {
                return ONE_ITEM;
            }
        }

        class OneViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            ImageView iv;

            public OneViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.adapter1);
            }
        }

        class TwoViewHolder extends RecyclerView.ViewHolder {
            TextView tv1, tv2;

            public TwoViewHolder(View itemView) {
                super(itemView);
                tv1 = (TextView) itemView.findViewById(R.id.adapter2);
                tv2 = (TextView) itemView.findViewById(R.id.adapter3);
            }
        }
    }
}
