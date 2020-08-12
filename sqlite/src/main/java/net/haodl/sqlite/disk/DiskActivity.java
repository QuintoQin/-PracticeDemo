package net.haodl.sqlite.disk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jakewharton.disklrucache.DiskLruCache;

import net.haodl.sqlite.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DiskActivity extends AppCompatActivity {
    private static final String TAG = "DiskActivity";
    private DiskLruCache mDiskLruCache = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disk);
        try {
            File cacheDir = DiskUtil.getDiskCacheDir(getApplicationContext(), "bitmap");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            mDiskLruCache = DiskLruCache.open(cacheDir, DiskUtil.getAppVersion(getApplicationContext()), 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
//                String key = DiskUtil.hashKeyForDisk(imageUrl);
//                Log.e(TAG, key);
//                try {
//                    DiskLruCache.Editor editor = mDiskLruCache.edit(key);
//                    if (editor != null) {
//                        OutputStream outputStream = editor.newOutputStream(0);
//                        if (DiskUtil.downloadUrlToStream(imageUrl, outputStream)) {
//                            editor.commit();
//                            Log.e(TAG,"成功");
//                        } else {
//                            editor.abort();
//                        }
//                    }
//                    mDiskLruCache.flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        ImageView iv = (ImageView) findViewById(R.id.iv);
        String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
        String key = DiskUtil.hashKeyForDisk(imageUrl);
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
            if (snapshot != null) {
                InputStream is = snapshot.getInputStream(0);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                iv.setImageBitmap(bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
