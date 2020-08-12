//package com.example.user.practicedemo;
//
//import android.Manifest;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.zhy.m.permission.MPermissions;
//import com.zhy.m.permission.PermissionDenied;
//import com.zhy.m.permission.PermissionGrant;
//
//public class Main2Activity extends AppCompatActivity {
//    private static final int REQUECT_CODE = 10;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        TextView tv = (TextView) findViewById(R.id.tv);
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MPermissions.requestPermissions(Main2Activity.this, REQUECT_CODE, Manifest.permission.SYSTEM_ALERT_WINDOW);
//            }
//        });
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
//    {
//        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//
//
//    @PermissionGrant(REQUECT_CODE)
//    public void requestSdcardSuccess()
//    {
//        Toast.makeText(this, "GRANT ACCESS!", Toast.LENGTH_SHORT).show();
//    }
//
//    @PermissionDenied(REQUECT_CODE)
//    public void requestSdcardFailed()
//    {
//        Toast.makeText(this, "DENY ACCESS!", Toast.LENGTH_SHORT).show();
//    }
//}
