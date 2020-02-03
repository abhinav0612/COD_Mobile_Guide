package com.deathalurer.codmobileguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.deathalurer.codmobileguide.Fragments.CustomAmmoDialogFragment;

import java.util.List;

/**
 * Created by Abhinav Singh on 07,October,2019
 */
public class CustomAmmoAdapter extends RecyclerView.Adapter<CustomAmmoAdapter.AmmoViewHolder> {
    List<Recycler_Item> weaponList;
    Fragment fragment;

    public CustomAmmoAdapter(List<Recycler_Item> weaponList,Fragment fragment) {
        this.weaponList = weaponList;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public AmmoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new AmmoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AmmoViewHolder holder, final int position) {
        holder.textView.setText(weaponList.get(position).getName());
        holder.imageView.setImageResource(weaponList.get(position).getImageResId());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            Recycler_Item item = weaponList.get(position);
            @Override
            public void onClick(View view) {
                CustomAmmoDialogFragment dialgoFragment = new CustomAmmoDialogFragment(item.getName(),item.getImageResId(),item.getWeaponList());
                dialgoFragment.show(fragment.getActivity().getSupportFragmentManager(),"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return weaponList.size();
    }

    public class AmmoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private CardView cardView;
        public AmmoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item);
            textView = itemView.findViewById(R.id.item_text);
            cardView = itemView.findViewById(R.id.cardViewItem);        }
    }
}
