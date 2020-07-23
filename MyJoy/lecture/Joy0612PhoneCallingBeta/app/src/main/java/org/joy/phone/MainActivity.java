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
    private static final int MY_REQUEST_CODE = 1;
    private TelephonyManager mTelephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a telephony manager.
        /*
        mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if (isTelephonyEnabled()) {
            Log.d(TAG, "Telephony is enabled");
            checkForPhonePermission();             // Check for phone permission.
        } else {
            Toast.makeText(this, R.string.telephony_disabled, Toast.LENGTH_LONG).show();
            Log.d(TAG, getString(R.string.telephony_disabled));
        }
        */
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
        Intent dialIntent = new Intent(Intent.ACTION_CALL);
        dialIntent.setData(Uri.parse(phoneNumber));

        checkForPhonePermission();
        startActivity(dialIntent);
        Log.d(TAG, "<dialNumber:" + phoneNumber);
    }

    private boolean isTelephonyEnabled() {
        if (mTelephonyManager != null) {
            if (mTelephonyManager.getSimState() == TelephonyManager.SIM_STATE_READY) {
                return true;
            }
        }
        return false;
    }

    private void checkForPhonePermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Permission already granted.");
        }
        else {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE)){
                ActivityCompat.requestPermissions(this, new String[] {
                                Manifest.permission.CALL_PHONE}, MY_REQUEST_CODE );
                Log.d(TAG, "PERMISSION GRANTED 1");
            }
            else {
                Log.d(TAG, getString(R.string.permission_not_granted));
            }
            ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE}, MY_REQUEST_CODE );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult");
        // Check if permission is granted or not for the request.
        switch (requestCode) {
            case MY_REQUEST_CODE : {
                if (permissions[0].equalsIgnoreCase(Manifest.permission.CALL_PHONE)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted.
                    Log.d(TAG, "PERMISSION GRANTED 2");
                } else {
                    // Permission denied.
                    Log.d(TAG, "Failure to obtain permission!");
                    Toast.makeText(this, "Failure to obtain permission!",
                            Toast.LENGTH_LONG).show();
                }
            }
            default:
                Log.d(TAG, "NOT MY_REQUEST");
                break;
        }
    }
}