package org.joy.widget;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

// https://abhiandroid.com/ui/dynamic-relativelayout-params-programmatically.html

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout = findViewById(R.id.simpleRelativeLayout);

        HuButton buttonFaith = new HuButton(this);
        buttonFaith.setText("Walk by Faith");
        buttonFaith.setId(View.generateViewId());
        LayoutParams paramsFaith = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        paramsFaith.setMargins(8, 8, 8, 8); // left, top, right, bottom
        paramsFaith.addRule(RelativeLayout.CENTER_IN_PARENT);
        buttonFaith.setLayoutParams(paramsFaith);
        layout.addView(buttonFaith);

        /////////////////////////////////////////////////////////////

        HuButton buttonSight = new HuButton(this);
        buttonSight.setText("Not by Sight");
        LayoutParams paramsSight = new LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        paramsSight.addRule(RelativeLayout.BELOW, buttonFaith.getId());
        buttonSight.setLayoutParams(paramsSight);
        layout.addView(buttonSight);
    }
}