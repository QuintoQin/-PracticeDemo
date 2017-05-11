package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.*;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] title = {"item1", "item2", "item3", "item4", "item5", "item1", "item2", "item3", "item4", "item5", "item1", "item2", "item3", "item4", "item5"};
    int[] resImage = {R.drawable.item1, R.drawable.item2,
            R.drawable.item3, R.drawable.item4, R.drawable.item5, R.drawable.item1, R.drawable.item2,
            R.drawable.item3, R.drawable.item4, R.drawable.item5, R.drawable.item1, R.drawable.item2,
            R.drawable.item3, R.drawable.item4, R.drawable.item5};
    List<Item> list;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        initData();
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        adapter = new Adapter(list, this);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Item item = new Item();
            item.setName(getRandomLengthName(title[i]));
            item.setImageRes(resImage[i]);
            list.add(item);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
