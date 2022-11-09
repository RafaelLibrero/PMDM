package com.rafaellibrero.programacionmultimedia.ui.picture.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaellibrero.programacionmultimedia.R;

import java.util.ArrayList;

public class RVAdapter
        extends RecyclerView.Adapter<RVAdapter.MyViewHolder>
        implements  View.OnClickListener {

    private ArrayList<ListElement> list;
    private View.OnClickListener listener;

    public RVAdapter(ArrayList<ListElement> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_picture, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public void onClick(View view) {
        if(listener!= null){
            listener.onClick(view);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
