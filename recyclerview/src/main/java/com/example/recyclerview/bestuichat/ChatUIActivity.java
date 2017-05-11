package com.example.recyclerview.bestuichat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.*;
import android.support.v7.widget.*;
import android.widget.LinearLayout;

/**
 * 编写的一个简易聊天界面
 */
public class ChatUIActivity extends AppCompatActivity {
    private List<Msg> list = new ArrayList<>();
    private EditText et;
    private Button btn;
    private RecyclerView recyclerView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_ui);
        initMsgs();
        initViews();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(list);
        recyclerView.setAdapter(msgAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    list.add(msg);
                    msgAdapter.notifyItemInserted(list.size() - 1);
                    recyclerView.scrollToPosition(list.size() - 1);
                    et.setText("");
                }
            }
        });

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.msg_rl);
        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy", Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("Hello. who are you?", Msg.TYPE_SEND);
        Msg msg3 = new Msg("This is Tom.", Msg.TYPE_RECEIVED);
        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
    }
}
