package org.joy.phone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "HuStar";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkForSmsPermission();
        Log.d(TAG, "<onCreate");
    }

   public void smsSendMessage(View view) {
        Log.d(TAG, ">sendSmsMessage: ");
        EditText editText = (EditText) findViewById(R.id.number_to_call);
        String smsNumber = "smsto: " + editText.getText().toString();

        EditText smsEditText = (EditText) findViewById(R.id.sms_message);
        String sms = smsEditText.getText().toString();

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse(smsNumber));
        smsIntent.putExtra("sms_body", sms);

        startActivity(smsIntent);
        Log.d(TAG, "<sendSmsMessage: " + sms);
   }

   private void checkForSmsPermission() {
        Log.d(TAG, ">checkForSmsPermission ");

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Permission denied");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            Log.d(TAG,"Permission already granted");
        }
        Log.d(TAG,"<checkForSmsPermission");
   }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
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
                Log.d(TAG,"Pass - not my request");
                break;
        }
    }
}