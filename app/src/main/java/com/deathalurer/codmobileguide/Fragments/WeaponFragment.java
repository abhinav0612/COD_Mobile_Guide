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
import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.Recycler_Item;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class WeaponFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Recycler_Item> dataList;
    private AdView adView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weapon,container,false);

        addData();
        recyclerView = view.findViewById(R.id.recycler_view);
        adView = view.findViewById(R.id.adView);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        CustomAdapter adapter = new CustomAdapter(dataList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(WeaponFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Recycler_Item("Assault",R.drawable.akoneoneseven));
        dataList.add(new Recycler_Item("Sniper",R.drawable.arcticdotfivezero));
        dataList.add(new Recycler_Item("LMG",R.drawable.mfourlmg));
        dataList.add(new Recycler_Item("SMG",R.drawable.chicom));
        dataList.add(new Recycler_Item("Pistols",R.drawable.jthreefiveeight));
        dataList.add(new Recycler_Item("Launcher",R.drawable.fhj_eighteen));
        dataList.add(new Recycler_Item("Shotgun",R.drawable.byfiveteen));


    }
}
