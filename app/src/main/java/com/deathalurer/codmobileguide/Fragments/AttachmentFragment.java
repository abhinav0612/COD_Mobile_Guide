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
import com.deathalurer.codmobileguide.CustomAtachmentAdapter;
import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.Recycler_Item;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class AttachmentFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Recycler_Item> dataList;
    private AdView adView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attachments,container,false);

        addData();
        adView = view.findViewById(R.id.adViewAttachment);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        recyclerView = view.findViewById(R.id.recycler_view);
        CustomAtachmentAdapter adapter = new CustomAtachmentAdapter(dataList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(AttachmentFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        dataList = new ArrayList<>();
        dataList.add(new Recycler_Item("Red Dot Sight",R.drawable.reddot,"Precision red dot sight.","+5","+5"));
        dataList.add(new Recycler_Item("Holographic Sight",R.drawable.holo,"Provides a better view of targets vs reflex sights, but with less peripheral vision.","+5","+5"));
        dataList.add(new Recycler_Item("Tactical Scope",R.drawable.tactical,"Enhanced variable zoom sight.","+6","+5"));
        dataList.add(new Recycler_Item("Fore Grip",R.drawable.foregrip,"Reduced recoil while aiming down the sights.","+10","null"));
        dataList.add(new Recycler_Item("Silencer",R.drawable.silencer,"Gunfire is hidden on enemy mini-map and makes it harder to be located.","null","null"));
        dataList.add(new Recycler_Item("Fast Mag",R.drawable.fastmag,"Reduce reloading time.","null","null"));
        dataList.add(new Recycler_Item("Extended Mag",R.drawable.extendedmag,"Increase magazine capacity.","null","null"));
        dataList.add(new Recycler_Item("Laser Sight",R.drawable.laser,"Increases accuracy.","+10","null"));
        dataList.add(new Recycler_Item("Stock",R.drawable.stock,"Increases move speed while aiming.","Mobility : +10","null"));
        dataList.add(new Recycler_Item("FMJ",R.drawable.fmj,"Increases material penetration.","Damage : +10","null"));
        dataList.add(new Recycler_Item("Quick Draw",R.drawable.quick,"Increase aim speed.","null","null"));
        dataList.add(new Recycler_Item("Long Barrel",R.drawable.longbarrel,"Increase range.","","+10"));

    }
}
