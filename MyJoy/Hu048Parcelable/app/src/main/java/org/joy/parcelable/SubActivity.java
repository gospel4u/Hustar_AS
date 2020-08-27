package org.joy.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    public static final String GOOD_NEWS = "org.joy.parcelable.GOOD_NEWS";
    public static final String JOHN_316 = "org.joy.parcelable.JOHN_316";
    public static final String GAL_220 = "org.joy.parcelable.GAL_220";
    SimpleData simpleData;
    BriefData briefData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate>>");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        View view = findViewById(R.id.mainView);
        Button button = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();
        simpleData = bundle.getParcelable(JOHN_316);
        briefData = (BriefData) bundle.getSerializable(GAL_220);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(JOHN_316, simpleData);
                intent.putExtra(GAL_220, briefData);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        ArrayList<String> list = (ArrayList<String>) intent.getSerializableExtra(GOOD_NEWS);
        SimpleData data = intent.getParcelableExtra(JOHN_316);
        BriefData briefData = (BriefData) intent.getSerializableExtra(GAL_220);

        if (list != null) {
            String msg = "";
            for (String x : list) {
                msg += x + " ";
            }
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }

        if (data != null && briefData != null) {
            String datalist = "";
            datalist = data.message + data.number +"\n"+ briefData.number
                        + briefData.message + briefData.name;
            Snackbar.make(view , datalist, Snackbar.LENGTH_LONG).show();
        }

    }
}