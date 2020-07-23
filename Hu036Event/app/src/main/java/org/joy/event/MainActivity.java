package org.joy.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ScrollView scrollView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        textView = findViewById(R.id.textView);
        View view = findViewById(R.id.view);
        View view2 = findViewById(R.id.view2);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float curx = motionEvent.getX();
                float cury = motionEvent.getY();
                if (action == MotionEvent.ACTION_DOWN) {
                    println("손가락 눌림 : " +curx + ", " + cury);
                } else if (action == motionEvent.ACTION_MOVE) {
                    println("손가락 움직임: " +curx + ", " + cury);
                } else if (action == motionEvent.ACTION_UP) {
                    println("손가락 땜: "+ curx + ", " + cury);
                }
                return true;
            }
        });

            detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent motionEvent) {
                    println("onDown() 호출됨.");
                    return true;
                }

                @Override
                public void onShowPress(MotionEvent motionEvent) {
                    println("onShowPress 호출됨.");
                }

                @Override
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    println("onSingleTapUp 호출됨.");
                    return true;
                }

                @Override
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                    println("onScroll() 호출됨.");
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent motionEvent) {
                    println("onLongPress() 호출됨.");
                }

                @Override
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                    println("onFling() 호출됨.");
                    return true;
                }
            });

            view2.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    detector.onTouchEvent(motionEvent);
                    return true;
                }
            });
        }


    public void println(String data) {
        textView.append(data + "\n");
        scrollView.fullScroll(View.FOCUS_DOWN); // auto scrolling
    }
}