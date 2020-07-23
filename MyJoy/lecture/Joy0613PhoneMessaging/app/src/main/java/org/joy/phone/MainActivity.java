package org.joy.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, MainActivity.class.getSimpleName());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialNumber(View view) {
        Log.d(TAG, ">dialNumber");
        TextView textView = (TextView) findViewById(R.id.number_to_call);

        // Use format with "tel:" and phone number to create mPhoneNum.
        String phoneNumber = String.format("tel: %s", textView.getText().toString());
        // Create the intent and set the data for the intent as the phone number.
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse(phoneNumber));
        startActivity(dialIntent);

        Log.d(TAG, "<dialNumber:" + phoneNumber);
    }

    public void smsSendMessage(View view) {
        TextView textView = (TextView) findViewById(R.id.number_to_call);
        // Use format with "smsto:" and phone number to create smsNumber.
        String smsNumber = String.format("smsto: %s", textView.getText().toString());

        // Find the sms_message view and get the text of the SMS message.
        EditText smsEditText = (EditText) findViewById(R.id.sms_message);
        String sms = smsEditText.getText().toString();

        // Create the intent and Set the data for the intent as the phone number.
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse(smsNumber));

        // Add the message (sms) with the key ("sms_body") and send intent
        smsIntent.putExtra("sms_body", sms);
        startActivity(smsIntent);

        Log.d(TAG, "smsSendMessage: " + sms);
    }
}