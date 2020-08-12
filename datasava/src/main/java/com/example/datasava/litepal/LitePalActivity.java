package com.example.datasava.litepal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.datasava.R;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class LitePalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
            }
        });

        findViewById(R.id.find).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book : books) {
                    Toast.makeText(LitePalActivity.this, "name==" + book.getName() + "  author==" + book.getAuthor() + "  pages==" + book.getPages() + "  price==" + book.getPrice(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
