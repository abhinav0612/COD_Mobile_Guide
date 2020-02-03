package com.deathalurer.codmobileguide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deathalurer.codmobileguide.CustomAdapter;
import com.deathalurer.codmobileguide.CustomDetailsAdapter;
import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.Recycler_Item;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class ThrowableFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Recycler_Item> dataList;
    private AdView adView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.throwable,container,false);

        addData();
        recyclerView = view.findViewById(R.id.recycler_view);
        adView = view.findViewById(R.id.adViewThrowbale);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        CustomDetailsAdapter adapter = new CustomDetailsAdapter(dataList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(ThrowableFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Recycler_Item("Sticky Grenade",R.drawable.sticky,"A grenade that sticks to surfaces before detonating."));
        dataList.add(new Recycler_Item("Frag Grenade",R.drawable.frag,"Explodes after a short delay."));
        dataList.add(new Recycler_Item("Trip Mine",R.drawable.trip,"Magnetic mine that detonates when an enemy trips that laser trigger."));
        dataList.add(new Recycler_Item("Flash Bang",R.drawable.flash,"Device that blind and deafens the target when detonated."));
        dataList.add(new Recycler_Item("Smoke Grenade",R.drawable.smoke,"Grenade that creates a smokescreen when detonated."));
        dataList.add(new Recycler_Item("EMP",R.drawable.emp,"Disorients and slow enemy movement speed."));
        dataList.add(new Recycler_Item("Concussion Grenade",R.drawable.consussion,"Damage and disables nearby mechanized enemy unites and equipment."));
        dataList.add(new Recycler_Item("Trophy System",R.drawable.trophy,"Adeployable autonomous defense system that destroys incoming explosives."));

    }
}
