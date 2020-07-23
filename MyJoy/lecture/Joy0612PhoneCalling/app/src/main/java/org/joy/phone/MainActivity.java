package org.joy.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "HuStar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, MainActivity.class.getSimpleName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callNumber(View view) {
        Log.d(TAG, ">dialNumber");
        EditText editText = (EditText) findViewById(R.id.number_to_call);
        // Use format with "tel:" and phone number to create mPhoneNum.
        String phoneNumber = String.format("tel: %s", editText.getText().toString());

        Log.d(TAG, getString(R.string.phone_dialing) + phoneNumber);
        Toast.makeText(this, R.string.phone_dialing + phoneNumber,
                Toast.LENGTH_LONG).show();

        // Create the intent and set the data for the intent as the phone number.
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(phoneNumber));

        startActivity(callIntent);
        Log.d(TAG, "<callNumber:" + phoneNumber);
    }
}