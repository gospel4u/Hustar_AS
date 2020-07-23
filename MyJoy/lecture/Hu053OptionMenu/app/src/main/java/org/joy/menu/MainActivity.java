package org.joy.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Menu menu_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int curId = item.getItemId();
       switch(curId) {
           case R.id.menu_refresh:
               Toast.makeText(this, "refesh selected", Toast.LENGTH_SHORT).show();
               break;
           case R.id.menu_search:
               Toast.makeText(this, "search selected", Toast.LENGTH_SHORT).show();
               break;
           case R.id.menu_settings:
               Toast.makeText(this, "settings selected", Toast.LENGTH_SHORT).show();
               break;
           default:
               break;
       }
       return super.onOptionsItemSelected(item);
    }


}