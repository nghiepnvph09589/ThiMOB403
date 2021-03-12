package com.example.thi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Products> contactArrayList;
    public DataAdapter(ArrayList<Products> contactArrayList){
        this.contactArrayList = contactArrayList;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent,
                        false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int i) {
        Picasso.get().load(contactArrayList.get(i).getSearch_image()).into(holder.img);
        holder.styleid.setText(contactArrayList.get(i).getStyleid());
        holder.brands_filter_facet.setText(contactArrayList.get(i).getBrands_filter_facet());
        holder.price.setText(contactArrayList.get(i).getPrice());

    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView styleid, brands_filter_facet, price;
        public ViewHolder(View view){
            super(view);
            img = (ImageView)view.findViewById(R.id.img);
            styleid = (TextView)view.findViewById(R.id.styleid);
            brands_filter_facet = (TextView)view.findViewById(R.id.bff);
            price = (TextView)view.findViewById(R.id.price);
        }
    }

}
