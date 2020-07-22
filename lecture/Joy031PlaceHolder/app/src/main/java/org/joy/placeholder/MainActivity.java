package org.joy.placeholder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private Placeholder placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(">onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void swapView(View v) {
        TransitionManager.beginDelayedTransition(layout);
        placeholder.setContentId(v.getId());
    }

}