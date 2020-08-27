package org.joy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //LinearLayoutManager layoutManager = new
        //                      LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        //ArrayList<Person> dataSet = new ArrayList<Person>();

        final PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("김민수", "010-1000-1000"));
        adapter.addItem(new Person("김하늘", "010-2000-2000"));
        adapter.addItem(new Person("홍길동", "010-3000-3000"));
        adapter.addItem(new Person("yes", "010-4000-4000"));
        adapter.addItem(new Person("God", "333"));
        adapter.addItem(new Person("good", "010-5000-5000"));
        adapter.addItem(new Person("김민수", "010-1000-1000"));
        adapter.addItem(new Person("김하늘", "010-2000-2000"));
        adapter.addItem(new Person("홍길동", "010-3000-3000"));
        adapter.addItem(new Person("yes", "010-4000-4000"));
        adapter.addItem(new Person("God", "333"));
        adapter.addItem(new Person("good", "010-5000-5000"));
        adapter.addItem(new Person("김민수", "010-1000-1000"));
        adapter.addItem(new Person("김하늘", "010-2000-2000"));
        adapter.addItem(new Person("홍길동", "010-3000-3000"));
        adapter.addItem(new Person("yes", "010-4000-4000"));
        adapter.addItem(new Person("God", "333"));
        adapter.addItem(new Person("good", "010-5000-5000"));

        recyclerView.setAdapter(adapter);

        //adapter.setItems(dataSet);


        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                adapter.addItemsSelected(position);
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "item: " + item.getName(), Toast.LENGTH_LONG).show();
                Snackbar.make(view, adapter.getItemsSelected().toString(), Snackbar.LENGTH_INDEFINITE).show();

                ArrayList<Integer> itemsSelected = adapter.getItemsSelected();
                if (itemsSelected.contains(position)) {
                    view.setBackgroundColor(Color.YELLOW);
                } else {
                    view.setBackgroundColor(Color.WHITE);
                }

            }
        });

    }
}