package org.joy.activity;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "org.joy.activity.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("HuStar", "MainActivity");
    }

    /** Called when the user taps the Send button */
    /*
    public void sendMessage(View view) {
        Log.d("HuStar", ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d("HuStar", "<sendMessage");
    }
    */
    

    private String getMessage(View v) {
        EditText et = new EditText(this);
        switch(v.getId()) {
            case R.id.button:
                et = findViewById(R.id.editText);
                break;
            case R.id.button2:
                et = findViewById(R.id.editText2);
                break;
        }
        return et.getText().toString();
    }

    public void sendMessage(View view) {
        Log.d("HuStar", ">sendMessage");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, getMessage(view));
        startActivity(intent);
        Log.d("HuStar", "<sendMessage");
    }
}