package com.deathalurer.codmobileguide.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.deathalurer.codmobileguide.R;

/**
 * Created by Abhinav Singh on 07,October,2019
 */
public class CustomDialgoFragment extends AppCompatDialogFragment {
    private String name;
    private int imageID;
    private String desc;

    public CustomDialgoFragment(String name, int imageID, String desc) {
        this.name = name;
        this.imageID = imageID;
        this.desc = desc;
    }

    private TextView title,desciption,range,accu;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.custom_dialog_fragment,null);
        builder.setView(view);

        title = view.findViewById(R.id.customDialogTitle);
        desciption=view.findViewById(R.id.customDialogDesc);
        accu = view.findViewById(R.id.customDialogAcc);
        range = view.findViewById(R.id.customDialogRange);

        range.setVisibility(View.GONE);
        accu.setVisibility(View.GONE);
        title.setText(name);
        desciption.setText(desc);


        return builder.create();
    }
}

