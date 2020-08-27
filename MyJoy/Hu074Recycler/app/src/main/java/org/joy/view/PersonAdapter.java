package org.joy.view;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
                implements OnPersonItemClickListener{
    ArrayList<Person> items = new ArrayList<>();
    private ArrayList<Integer> itemsSelected = new ArrayList<>();
    OnPersonItemClickListener listener;

    public ArrayList<Person> getItems() {
        return items;
    }

    public ArrayList<Integer> getItemsSelected() {
        return itemsSelected;
    }

    public void setItemsSelected(ArrayList<Integer> itemsSelected) {
        this.itemsSelected = itemsSelected;
    }

    public OnPersonItemClickListener getListener() {
        return listener;
    }

    public void setListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.setItem(item);

        if (itemsSelected.contains(position)) {
            holder.itemView.setBackgroundColor(Color.YELLOW);
        }
        else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Person item) {
        items.add(item);
    }

    public void setItems(ArrayList<Person> items) {
        this.items = items;
    }

    public Person getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Person item) {
        items.set(position, item);
    }

    public void setOnItemClickListener (OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder,view,position);

            if (itemsSelected.contains(position)) {
                holder.itemView.setBackgroundColor(Color.YELLOW);
            }
            else {
                holder.itemView.setBackgroundColor(Color.WHITE);
            }
        }
    }

    public void addItemsSelected(int position) {
        if (itemsSelected.contains(position)) {
            itemsSelected.remove((Integer)position);
        } else {
            itemsSelected.add(position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Person item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }

    }
}
