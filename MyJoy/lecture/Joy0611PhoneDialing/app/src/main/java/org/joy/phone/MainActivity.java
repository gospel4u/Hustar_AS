package org.joy.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class    MainActivity extends AppCompatActivity {
    // public static final String TAG = MainActivity.class.getSimpleName();
    public static final String TAG = "HuStar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, MainActivity.class.getSimpleName());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //using  anonymous class listener object
        /**
        ImageButton phoneIcon = findViewById(R.id.phone_icon);
        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialNumber(view);
            }
        });
         **/
    }

    public void dialNumber(View view) {
        Log.d(TAG, ">dialNumber");
        TextView textView = (TextView) findViewById(R.id.number_to_call);

        // Use format with "tel:" and phone number to create mPhoneNum.
        String phoneNumber = String.format("tel: %s", textView.getText().toString());
        // Create the intent.
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        dialIntent.setData(Uri.parse(phoneNumber));
        startActivity(dialIntent);

        Log.d(TAG, "<dialNumber:" + phoneNumber);
    }
}