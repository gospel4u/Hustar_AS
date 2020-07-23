package org.joy.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkForSmsPermission();
        Log.d(TAG, "<onCreate");
    }

    private void checkForSmsPermission() {
        Log.d(TAG, ">checkForSmsPermission ");
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission denied");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            // Permission already granted.
            Log.d(TAG, "Permission already granted");
        }
        Log.d(TAG, "<checkForSmsPermission ");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // Check if permission is granted or not for the request.
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase(Manifest.permission.SEND_SMS)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Permission granted");
                } else {
                    Log.d(TAG, "Permission denied");
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
                }
            }
            default:
                Log.d(TAG, "Pass - not my request");
                break;
        }
    }

    public void smsSendMessage(View view) {
        Log.d(TAG, ">sendSmsMessage: ");
        closeKeyboard();

        EditText editText = (EditText) findViewById(R.id.number_to_call);
        // Use format with "smsto:" and phone number to create smsNumber.
        String smsNumber = String.format("smsto: %s", editText.getText().toString());

        // Find the sms_message view and get the text of the sms message.
        EditText smsEditText = (EditText) findViewById(R.id.sms_message);
        String sms = smsEditText.getText().toString();

        // Create the intent and set the data for the intent as the phone number.
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse(smsNumber));
        // Add the message (sms) with the key ("sms_body").
        smsIntent.putExtra("sms_body", sms);

        startActivity(smsIntent);
        Log.d(TAG, "<sendSmsMessage: " + sms);
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}


