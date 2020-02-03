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
public class CustomAttachmentDialgoFragment extends AppCompatDialogFragment {
    private String name;
    private int imageID;
    private String desc;
    private String accuacy;
    private String rangee;

    public CustomAttachmentDialgoFragment(String name, int imageID, String desc, String accuacy, String rangee) {
        this.name = name;
        this.imageID = imageID;
        this.desc = desc;
        this.accuacy = accuacy;
        this.rangee = rangee;
    }

    private TextView title,desciption,accu,range;
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

        title.setText(name);
        desciption.setText(desc);
        if (accuacy.contains("Damage")||accuacy.contains("Mobility")||accuacy.contains("null"))
            accu.setText(accuacy);
            if (accuacy.equals("null"))
                accu.setVisibility(View.GONE);
        else
            accu.setText("Accuracy : "+accuacy);

        if (rangee.contains("null"))
            range.setVisibility(View.GONE);
        else
            range.setText("Range : "+rangee);


        return builder.create();
    }
}

