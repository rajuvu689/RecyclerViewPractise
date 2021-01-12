package com.rtsoftworld.recyclerviewpractise.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.rtsoftworld.recyclerviewpractise.DetailsActivity;
import com.rtsoftworld.recyclerviewpractise.Model.ListItems;
import com.rtsoftworld.recyclerviewpractise.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItems> listItems;  // list of item model

    public MyAdapter(Context context, List<ListItems> listItems) {  // constractor
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItems items = listItems.get(position); // store the data position of data array in item object
        holder.name.setText(items.getName());  // set name to name text view field
        holder.description.setText(items.getDescription()); // set description to description text view field
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    } //return the array size

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {  // need this class to access each list item to show
        public TextView name;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            ListItems items = listItems.get(position);
            //Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context,DetailsActivity.class);
            i.putExtra("name",items.getName());  //send name data by intent to next activity
            i.putExtra("description",items.getDescription());
            context.startActivity(i);

        }
    }
}
