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
import com.deathalurer.codmobileguide.CustomAmmoAdapter;
import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.Recycler_Item;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class AmmoFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Recycler_Item> dataList;
    private AdView adView;

    private List<String> list_five,list_seven,list_four,list_nine,list_rockets,list_guage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ammo,container,false);
        addWeaponList();
        addData();
        adView = view.findViewById(R.id.adViewAmmo);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        recyclerView = view.findViewById(R.id.recycler_view);
        CustomAmmoAdapter adapter = new CustomAmmoAdapter(dataList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(AmmoFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Recycler_Item("5.56",R.drawable.fivffive,list_five));
        dataList.add(new Recycler_Item("7.62",R.drawable.sevensix,list_seven));
        dataList.add(new Recycler_Item(".45",R.drawable.pointfour,list_four));
        dataList.add(new Recycler_Item("9mm",R.drawable.ninemm,list_nine));
        dataList.add(new Recycler_Item("Rockets",R.drawable.rocket,list_rockets));
        dataList.add(new Recycler_Item("12 Guage",R.drawable.twelwe,list_guage));

    }
    public void addWeaponList(){
        list_five = new ArrayList<>();
        list_five.add("M4");
        list_five.add("M16");
        list_five.add("Type 25");
        list_five.add("AK117");
        list_five.add("M4LMG");


        list_four = new ArrayList<>();
        list_four.add("MW11");


        list_guage = new ArrayList<>();
        list_guage.add("BY15");
        list_guage.add("Striker");
        list_guage.add("HS2126");
        list_guage.add("HS0405");


        list_rockets = new ArrayList<>();
        list_rockets.add("SMRS");
        list_rockets.add("FHJ-18");


        list_seven = new ArrayList<>();
        list_seven.add("RPD");
        list_seven.add("XPR-50");
        list_seven.add("Arctic .50");
        list_seven.add("ASM10");
        list_seven.add("LK24");


        list_nine = new ArrayList<>();

        list_nine.add("PDW-57");
        list_nine.add("AKS-74U");
        list_nine.add("Chicom");


    }
}
