package com.my_space.contactmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.my_space.contactmanager.R;
import com.my_space.contactmanager.model.Contact;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public MyAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_contact_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyAdapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.nameTv.setText(contact.getName());
        holder.phoneNumberTv.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTv, phoneNumberTv;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            phoneNumberTv = itemView.findViewById(R.id.phoneNumberTv);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
