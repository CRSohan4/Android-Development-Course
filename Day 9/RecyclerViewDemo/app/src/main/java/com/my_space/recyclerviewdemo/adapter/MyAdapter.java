package com.my_space.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.my_space.recyclerviewdemo.R;
import com.my_space.recyclerviewdemo.model.MyModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<MyModel> listItems;

    public MyAdapter(Context context, List<MyModel> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        MyModel item = listItems.get(position);

        holder.titleTv.setText(item.title);
        holder.descriptionTv.setText(item.description);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTv, descriptionTv;
        public ViewHolder(View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.title);
            descriptionTv = itemView.findViewById(R.id.description);
        }
    }
}
