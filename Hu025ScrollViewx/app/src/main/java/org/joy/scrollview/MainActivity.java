package org.joy.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Hustar";
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap01, bitmap02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        imageView = findViewById(R.id.imageView);
        scrollView.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap01 = (BitmapDrawable) res.getDrawable(R.drawable.alexhonnold0);
        bitmap02 = (BitmapDrawable) res.getDrawable(R.drawable.alexhonnold2);
        displayBitmap(bitmap01);


    }


    public void onButtonClicked(View view) {
        if (bitmap01.isVisible()) {
            bitmap01.setVisible(false, false);
            displayBitmap(bitmap02);

        } else {
            bitmap02.setVisible(false, false);
            displayBitmap(bitmap01);
        }
    }

    public void displayBitmap (BitmapDrawable bitmap) {
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
        imageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
    }


}