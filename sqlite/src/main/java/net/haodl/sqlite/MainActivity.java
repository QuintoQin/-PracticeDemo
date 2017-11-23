package net.haodl.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean useSQL = true;
    private SQLiteDatabase db;
    private EditText et1;
    private EditText et2;
    private TextView tv;
    private ContentValues cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.textView );
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        db = MyApp.getmDBHelper().getWritableDatabase();
        cv = new ContentValues();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //插入数据
            case R.id.button1:
                //使用SQL语句
                if (useSQL) {
                    db.execSQL("insert into study values(null, ?, ?)",
                            new Object[]{et1.getText().toString(), et2.getText().toString()});

                    //使用Android封装的方法
                } else {
                    //其中cv为ContentValues的实例
                    cv.put("bookName", et1.getText().toString());
                    cv.put("bookDesc", et2.getText().toString());

                    long isOK = db.insert("study", null, cv);

                    //-1代表操作失败
                    if (isOK == -1) {
                        Toast.makeText(MainActivity.this, "插入失败", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            //更新数据
            case R.id.button2:

                if (useSQL) {
                    db.execSQL("update study set bookName = ? where bookName = ?", new String[]{et1.getText().toString(), et2.getText().toString()});
                } else {
                    cv.put("bookName", et1.getText().toString());

                    int updateCount = db.update("study", cv, "bookName = ?", new String[]{et1.getText().toString()});

                    //更新后更新的个数，"0"表示更新失败
                    if (updateCount != 0) {
                        Toast.makeText(MainActivity.this, "更新成功，共更新个数：" + updateCount, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            //查询操作
            case R.id.button3:

                if (useSQL) {
                    Cursor cursor = db.rawQuery("select * from study", null);
                    StringBuilder sb = new StringBuilder();
                    for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                        sb.append("总数：" + cursor.getCount() + "\\\\n" + "书名：" + cursor.getString(cursor.getColumnIndex("bookName"))
                                + "----该书简介：" + cursor.getString(cursor.getColumnIndex("bookDesc")));
                        tv.setText(sb.toString());
                    }
                    //记得进行关闭哦
                    cursor.close();
                } else {
                    //查询该表中所有数据
                    Cursor c = db.query("study", null, null, null, null, null, null);

                    StringBuffer sb = new StringBuffer();
                    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                        sb.append("总数：" + c.getCount() + "\\\\n" + "书名：" + c.getString(c.getColumnIndex("bookName"))
                                + "----该书简介：" + c.getString(c.getColumnIndex("bookDesc")));
                        tv.setText(sb.toString());
                    }
                    //记得进行关闭哦
                    c.close();

                }
                break;

            //删除操作
            case R.id.button4:

                if (useSQL) {
                    db.execSQL("delete from study where bookName = ?", new String[]{et1.getText().toString()});
                } else {
                    db.delete("study", "bookName = ?", new String[]{et1.getText().toString()});
                }

                break;
        }

    }
}
