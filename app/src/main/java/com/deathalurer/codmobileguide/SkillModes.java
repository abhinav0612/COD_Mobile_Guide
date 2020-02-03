package com.deathalurer.codmobileguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class SkillModes extends Fragment {
    private RecyclerView recyclerView;
    private List<Recycler_Item> dataList;
    private AdView adView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classes,container,false);

        addData();
        adView = view.findViewById(R.id.adViewClasses);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        recyclerView = view.findViewById(R.id.recycler_view);
        CustomDetailsAdapter adapter = new CustomDetailsAdapter(dataList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(SkillModes.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Recycler_Item("Medic",R.drawable.medic,"Special equipment: Medical Station\n" +
                "\n" +
                "Place a medical station that heals you and allies continuously.\n" +
                "Passive skill: Medic\n" +
                "\n" +
                "Reduces time required for healing and bring back knocked down teammates by 25%.\n" +
                "Passive skill: Tracker\n" +
                "\n" +
                "Shows enemy footprints for several seconds."));
        dataList.add(new Recycler_Item("Scout",R.drawable.scout,"Special equipment: Sensor Dart\n" +
                "\n" +
                "Shoot a Sensor Dart that can see hostile positions in the radar map."));
        dataList.add(new Recycler_Item("Clown",R.drawable.clown,"Special equipment: Toy Bomb\n" +
                "\n" +
                "Summon zombies that only attacks units near them.\nPassive skill: Anti-zombie\n" +
                "\n" +
                "Reduces zombies' awareness distance to 15 meters"));
        dataList.add(new Recycler_Item("Ninja",R.drawable.ninja,"Special equipment: Grapple Hook\n" +
                "\n" +
                "Shoot a grapple hook that pulls you to the target.\nPassive skill: Dead Silence\n" +
                "\n" +
                "Reduces Sound when moving."));
        dataList.add(new Recycler_Item("Defender",R.drawable.defender,"Special equipment: Transform Shield\n" +
                "\n" +
                "Place a transformable and flashing shield.\nPassive skill: Reinforced\n" +
                "\n" +
                "Reduces damage from all sources except gunfire by 20%."));
        dataList.add(new Recycler_Item("Mechanic",R.drawable.drone,"Special equipment: EMP Drone\n" +
                "\n" +
                "Call an EMP Drone that does continous EMP interference to hostiles.\nPassive skill: Engineer\n" +
                "\n" +
                "Grants augmented sight, making vehicles, hostile traps and equipment visible within 80 meters."));
        dataList.add(new Recycler_Item("Airbone",R.drawable.airbone,"Special equipment: Ejection Device\n" +
                "\n" +
                "Summons a catapult, ejects your team into the air, and turns on the wing to glide.\nPassive skill: Lightweight\n" +
                "\n" +
                "Become more buoyant while using the wingsuit."));


    }
}
