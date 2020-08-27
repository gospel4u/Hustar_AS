package org.joy.parcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    public static final String GOOD_NEWS = "org.joy.parcelable.GOOD_NEWS";
    public static final String JOHN_316 = "org.joy.parcelable.JOHN_316";
    public static final String GAL_220 = "org.joy.parcelable.GAL_220";
    public static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate>>");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);

                ArrayList<String> list = new ArrayList<>();
                list.add("God is good");
                list.add("All the time!");
                intent.putExtra(GOOD_NEWS, list);

                SimpleData simpleData = new SimpleData(316, "God loves you!");
                intent.putExtra(JOHN_316, simpleData);

                BriefData briefData = new BriefData("GAL_220", 220, "Not I, but Christ");
                intent.putExtra(GAL_220,briefData);

                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        Log.d(TAG,"onCreate<<");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            View view = findViewById(R.id.mainView);

            ArrayList<String> list = bundle.getStringArrayList(GOOD_NEWS);
            SimpleData simpleData = bundle.getParcelable(JOHN_316);
            BriefData briefData = (BriefData) bundle.getSerializable(GAL_220);

            Snackbar.make(view, simpleData.message, Snackbar.LENGTH_LONG).show();
            Toast.makeText(this, briefData.message, Toast.LENGTH_LONG).show();
        }


    }


}