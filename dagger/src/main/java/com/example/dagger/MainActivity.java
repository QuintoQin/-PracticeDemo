package com.example.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dagger.shoe.Cloth;
import com.example.dagger.shoe.Clothes;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    TextView tv;
//    @Inject
//    Cloth cloth;
//    @Inject
//    Shoe shoe;
    @Inject
Clothes clothes;
    @Inject
    Cloth redCloth;
    //@Named("red")
    //@RedCloth

//    @Inject
//    @Named("blue")
//    Cloth blueCloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        //MainComponent bulid = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        //bulid.inject(this);
        //tv.setText("我现在有" + cloth.toString() + "和" + shoe.toString() + "和" + clothes.toString());
        //tv.setText("我现在有" + redCloth.toString() + "和" + blueCloth.toString());
        tv.setText("redCloth=clothes中的cloth吗?:" + (redCloth == clothes.getCloth()));
    }
}
