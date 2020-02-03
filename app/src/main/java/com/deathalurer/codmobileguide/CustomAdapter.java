package com.deathalurer.codmobileguide;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.deathalurer.codmobileguide.Fragments.AssaultFragment;
import com.deathalurer.codmobileguide.Fragments.DialogFragment;
import com.deathalurer.codmobileguide.Fragments.LMGFragment;
import com.deathalurer.codmobileguide.Fragments.LauncherFragment;
import com.deathalurer.codmobileguide.Fragments.PistolsFragment;
import com.deathalurer.codmobileguide.Fragments.SMGFragment;
import com.deathalurer.codmobileguide.Fragments.ShotgunFragment;
import com.deathalurer.codmobileguide.Fragments.SniperFragment;
import com.deathalurer.codmobileguide.Fragments.ThrowableFragment;

import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private List<Recycler_Item> mList;
    private Fragment fragment;

    public CustomAdapter(List<Recycler_Item> mList,Fragment context) {
        this.mList = mList;
        this.fragment = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        holder.textView.setText(mList.get(position).getName());
        holder.imageView.setImageResource(mList.get(position).getImageResId());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mList.get(position).getName()){
                    case "Assault" :
                        fragment.getActivity().getSupportFragmentManager()
                                .beginTransaction().replace(R.id.frameLayout,new AssaultFragment()).commit();
                        break;
                    case "Sniper" :
                        fragment.getActivity().getSupportFragmentManager()
                                .beginTransaction().replace(R.id.frameLayout,new SniperFragment()).commit();
                        break;
                    case "SMG" :
                        fragment.getActivity().getSupportFragmentManager()
                                .beginTransaction().replace(R.id.frameLayout,new SMGFragment()).commit();
                        break;
                    case "LMG" :
                        fragment.getActivity().getSupportFragmentManager()
                                .beginTransaction().replace(R.id.frameLayout,new LMGFragment()).commit();
                        break;
                    case "Pistols" :
                        fragment.getActivity().getSupportFragmentManager()
                                .beginTransaction().replace(R.id.frameLayout,new PistolsFragment()).commit();
                        break;
                    case "Launcher" :
                        fragment.getActivity().getSupportFragmentManager()
                                .beginTransaction().replace(R.id.frameLayout,new LauncherFragment()).commit();
                        break;
                    case "Shotgun" :
                        fragment.getActivity().getSupportFragmentManager()
                                .beginTransaction().replace(R.id.frameLayout,new ShotgunFragment()).commit();
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private CardView cardView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item);
            textView = itemView.findViewById(R.id.item_text);
            cardView = itemView.findViewById(R.id.cardViewItem);
        }
    }

}
