package com.example.automated_greenhouse;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder> {

    private ArrayList<Listing> items;
    private ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public ListingAdapter(Context context, ArrayList<Listing> items) {
        this.items = items;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTemperature, tvName, tvSoil, tvHumidity, tvPH, tvCount;
        ImageView imgType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgType = itemView.findViewById(R.id.imgType);
            tvTemperature = itemView.findViewById(R.id.tvTemp);
            tvName = itemView.findViewById(R.id.tvName);
            tvSoil = itemView.findViewById(R.id.tvSoil);
            tvHumidity = itemView.findViewById(R.id.tvHumidity);
            tvPH = itemView.findViewById(R.id.tvPH);
            tvCount = itemView.findViewById(R.id.tvCount);
        }
    }

    @NonNull
    @Override
    public ListingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(items.get(position));

        holder.tvName.setText(items.get(position).getItemName());
        holder.tvTemperature.setText(items.get(position).getItemTemperature());
        holder.tvSoil.setText(items.get(position).getItemSoil());
        holder.tvHumidity.setText(items.get(position).getItemHumidity());
        holder.tvPH.setText(items.get(position).getItemPH());

        holder.tvCount.setText((position+1) + "/" + getItemCount());

        holder.imgType.setImageResource(items.get(position).getItemImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

