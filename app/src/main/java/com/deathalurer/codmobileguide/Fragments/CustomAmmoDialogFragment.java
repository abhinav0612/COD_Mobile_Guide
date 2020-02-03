package com.deathalurer.codmobileguide.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.deathalurer.codmobileguide.AmmoAdapter;
import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.Recycler_Item;

import java.util.List;

/**
 * Created by Abhinav Singh on 07,October,2019
 */
public class CustomAmmoDialogFragment extends AppCompatDialogFragment {
    private String name;
    private int imageID;
    private List<String> list;

    public CustomAmmoDialogFragment(String name, int imageID, List<String> list) {
        this.name = name;
        this.imageID = imageID;
        this.list = list;
    }

    private TextView title;
    private RecyclerView recyclerView;
    private ImageView imageView;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.ammo_layout,null);
        builder.setView(view);

        title = view.findViewById(R.id.ammotext);
        imageView = view.findViewById(R.id.ammoimage);
        recyclerView = view.findViewById(R.id.recyclerammo);

        title.setText(name);
        imageView.setImageResource(imageID);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AmmoAdapter adapter = new AmmoAdapter(list);
        recyclerView.setAdapter(adapter);


        return builder.create();
    }
}

