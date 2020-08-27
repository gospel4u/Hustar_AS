package org.joy.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewFragment extends Fragment {
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_view, container, false);

        imageView = viewGroup.findViewById(R.id.imageView);

        return viewGroup;
    }

    public void setImage(int index) {
        imageView.setImageResource(index);
    }
}