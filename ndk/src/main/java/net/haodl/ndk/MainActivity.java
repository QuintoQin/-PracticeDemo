package net.haodl.ndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv);
        //tv.setText(helloWord());
    }

    static {
        //加载动态库，名字和c文件名相同
        System.loadLibrary("hello");
    }

    //声明本地方法
    //public native String helloWord();
}
