package com.deathalurer.codmobileguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Abhinav Singh on 07,October,2019
 */
public class AmmoAdapter extends RecyclerView.Adapter<AmmoAdapter.AmmoViewHolder> {
    List<String> weaponList;

    public AmmoAdapter(List<String> weaponList) {
        this.weaponList = weaponList;
    }

    @NonNull
    @Override
    public AmmoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.amoorecycleritem,parent,false);
        return new AmmoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AmmoViewHolder holder, int position) {
        holder.name.setText(weaponList.get(position));
    }

    @Override
    public int getItemCount() {
        return weaponList.size();
    }

    public class AmmoViewHolder extends RecyclerView.ViewHolder{
        private TextView name;

        public AmmoViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.amorecyclertext);
        }
    }
}
