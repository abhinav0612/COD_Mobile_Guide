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

import com.deathalurer.codmobileguide.CustomAdapter;
import com.deathalurer.codmobileguide.Dialog;
import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.Recycler_Item;
import com.deathalurer.codmobileguide.WeaponDetailsAdapter;
import com.deathalurer.codmobileguide.WeaponStats;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class SMGFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<WeaponStats> list;
    private AdView adView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smg,container,false);

        addData();
        adView = view.findViewById(R.id.adViewSMG);

        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        recyclerView = view.findViewById(R.id.recycler_view);
        WeaponDetailsAdapter adapter = new WeaponDetailsAdapter(list,this);
        recyclerView.setLayoutManager(new GridLayoutManager(SMGFragment.this.getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }
    public void addData(){
        list = new ArrayList<>();

        list.add(new WeaponStats(R.drawable.aks_sevenfouru,"AKS-74U",80,60,55,35,75,"B"));
        list.add(new WeaponStats(R.drawable.pdw_fiveseven,"PDW-57",90,50,40,75,25,"A"));
        list.add(new WeaponStats(R.drawable.msmc,"MSMC",75,70,45,80,30,"A"));
        list.add(new WeaponStats(R.drawable.hgfourty,"HG40",75,40,60,75,40,"C"));
        list.add(new WeaponStats(R.drawable.chicom,"Chicom",75,65,60,80,40,"S"));
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
