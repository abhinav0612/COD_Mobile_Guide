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
public class MapFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Recycler_Item> dataList;
    private AdView adView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maps,container,false);

        addData();
        adView = view.findViewById(R.id.adViewMaps);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        recyclerView = view.findViewById(R.id.recycler_view);
        CustomDetailsAdapter adapter = new CustomDetailsAdapter(dataList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(MapFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Recycler_Item("Crash",R.drawable.crash,"Crash is a medium-sized map that contains blind angles, small hallways, and dark areas, which is really effective for hiding or camping.\n" +
                "\n" +
                "Most combat will happen in close or medium quarters on this map. Make sure to equip a good close-range weapon for your loadout when playing on Crash."));
        dataList.add(new Recycler_Item("Standoff",R.drawable.standoff,"Standoff is a big map with several spots for long-range combat and a lot of paths that can cover yourself or escape back out from the gunfight."));
        dataList.add(new Recycler_Item("Kill House",R.drawable.killhouse,"Killhouse is a very small size map that provides a lot of covers on both sides, this map is good for practice sniping or testing weapons.\n" +
                "\n" +
                "Most combats will happen in close or medium quarters on this map."));
        dataList.add(new Recycler_Item("Hijacked",R.drawable.hijacked,"Hijacked is a map located on a large yacht that has a lot of angles to play around each side has 1 two-story structure good for sniping.\n" +
                "\n" +
                "Combat mostly happens in close to medium quarter on this map."));
        dataList.add(new Recycler_Item("Nuketown",R.drawable.nuketown,"Nuketown is a small map that has a lot of angles and covers that make close-range combat extremely effective"));
        dataList.add(new Recycler_Item("Raid",R.drawable.raid,"Raid is a huge map with a lot of areas and blind angles that players can hide or camp. Playing this map requires high awareness to avoid getting kill unexpectedly"));
        dataList.add(new Recycler_Item("Firing Range",R.drawable.firerange,"Firing range is a medium size map that has a lot of tactical corners and favors close combat players."));
        dataList.add(new Recycler_Item("Takeoff",R.drawable.takeoff,"Takeoff is a big map with a lot of areas to play in, there are some spots that can help you to escape from gunfight as well."));


    }
}
