package org.joy.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void dialNumber(View view) {
        TextView textView = (TextView) findViewById(R.id.number_to_call);
        String phoneNumber = "tel:" + textView.getText().toString();

        Intent dialIntent = new Intent(Intent.ACTION_DIAL);

        dialIntent.setData(Uri.parse(phoneNumber));

        startActivity(dialIntent);
        Log.d(TAG, "startActivity: " + phoneNumber);
    }

     */
    public void callNumber(View view) {
        EditText editText = findViewById(R.id.number_to_call);

        String phoneNumber = "tel:" + editText.getText().toString();

        Log.d(TAG, "Phone Status: DIALING: " +phoneNumber);
        Toast.makeText(this, "Phone Status: " + phoneNumber, Toast.LENGTH_LONG).show();

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(phoneNumber));

        startActivity(callIntent);
        Log.d(TAG, "<callNumber: " +phoneNumber);
    }
}