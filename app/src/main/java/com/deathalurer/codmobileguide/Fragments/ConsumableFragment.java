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
public class ConsumableFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Recycler_Item> dataList;
    private AdView adView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consume,container,false);

        addData();
        adView = view.findViewById(R.id.adViewConsume);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        recyclerView = view.findViewById(R.id.recycler_view);
        CustomDetailsAdapter adapter = new CustomDetailsAdapter(dataList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(ConsumableFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Recycler_Item("First Aid Kit",R.drawable.medikit,"Restores 80 HP"));
        dataList.add(new Recycler_Item("Adrenaline",R.drawable.adreline,"Restores full HP and increase max HP to 150"));
        dataList.add(new Recycler_Item("Hemostatic",R.drawable.homes,"Heal 20 HP over 10 seconds"));

    }
}
