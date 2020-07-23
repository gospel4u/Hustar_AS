package org.joy.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Boolean isPageOpen = false;
    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
    }

    public void onClicked(View view) {
        if (imageView1.isShown()) {
            imageView1.setVisibility(view.INVISIBLE);
            imageView2.setVisibility(view.VISIBLE);
        } else {
            imageView1.setVisibility(view.VISIBLE);
            imageView2.setVisibility(view.INVISIBLE);
        }
    }
}