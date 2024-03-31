package com.example.fetch7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private List<Item> items; // List of Item objects to be displayed in the RecyclerView.

    public ItemsAdapter(List<Item> items) {
        this.items = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view); // Create a new ViewHolder for the inflated view.
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items.get(position); // Get the current Item object based on position.

        holder.textView.setText("ListId: " + item.getListId() + ", Name: " + item.getName());
    }

    // Returns the total number of items in the list. This tells the RecyclerView how many items it needs to display.
    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView; // The textView within our item layout where we display the item's data.


        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(android.R.id.text1);
        }
    }
}
