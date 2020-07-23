package org.joy.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, password, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextPersonName3);


    }

    public void onClickedButton(View view) {
        show_message();
    }

    public void show_message() {
        String msg = "";
        if (name.getText().toString().isEmpty()) msg += "Enter a name; ";
        if (password.getText().toString().isEmpty()) msg += "Enter a password; ";
        if (email.getText().toString().isEmpty()) msg += "Enter a email; ";
        if (msg.length() != 0) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Name: " + name.getText().toString()
                    + " \n" + "Password: " + password.getText().toString()
                    + " \n" + "Email: " + email.getText().toString(),
                    Toast.LENGTH_LONG).show();
        }
        closeKeyboard();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void checkSelected() {
        if (!name.getText().toString().isEmpty()) name.selectAll();
        if (!password.getText().toString().isEmpty()) password.selectAll();
        if (!email.getText().toString().isEmpty()) email.selectAll();
    }
}