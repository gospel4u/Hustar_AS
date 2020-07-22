package org.joy.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback{
    ListFragment listFragment;
    ViewerFragment viewerFragment;
    int[] images = {R.drawable.alexhonnold1, R.drawable.alexhonnold2, R.drawable.alexhonnold3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment) manager.findFragmentById(R.id.listfragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerfragment);
    }

    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(images[position]);
    }
}