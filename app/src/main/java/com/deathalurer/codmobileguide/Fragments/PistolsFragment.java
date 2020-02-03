package com.deathalurer.codmobileguide.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deathalurer.codmobileguide.Dialog;
import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.WeaponDetailsAdapter;
import com.deathalurer.codmobileguide.WeaponStats;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class PistolsFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdView adView;

    private List<WeaponStats> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pistols,container,false);

        addData();
        adView = view.findViewById(R.id.adViewPistol);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        recyclerView = view.findViewById(R.id.recycler_view);
        WeaponDetailsAdapter adapter = new WeaponDetailsAdapter(list,this);
        recyclerView.setLayoutManager(new GridLayoutManager(PistolsFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        list = new ArrayList<>();
        list.add(new WeaponStats(R.drawable.mwoneone,"MW11",65,40,15,0,0,""));
        list.add(new WeaponStats(R.drawable.jthreefiveeight,"J358",80,15,40,0,0,""));


    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.back_menu, menu);

        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.moreinfo:
                //TODO
                Dialog dialog = new Dialog();
                dialog.show(getActivity().getSupportFragmentManager(),"");
                break;
            case R.id.backbutton:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new WeaponFragment())
                        .commit();
                break;
        }
        return false;
    }
}
