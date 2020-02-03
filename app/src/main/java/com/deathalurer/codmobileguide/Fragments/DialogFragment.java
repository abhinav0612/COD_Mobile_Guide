package com.deathalurer.codmobileguide.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.deathalurer.codmobileguide.R;
import com.deathalurer.codmobileguide.WeaponStats;

import java.util.List;

/**
 * Created by Abhinav Singh on 06,October,2019
 */
public class DialogFragment extends AppCompatDialogFragment {
    private List<WeaponStats> mlist;
    private String weaponName;
    private int Id;

    public DialogFragment(List<WeaponStats> mlist,String name,int imageID) {
        this.mlist = mlist;
        this.weaponName = name;
        this.Id = imageID;
    }

    private ImageView imageView;
    private TextView damage,accu,fir,mobi,tier,range,name;
    private Button close;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout,null);
        builder.setView(view);


        imageView=view.findViewById(R.id.dialogImage);
        damage=view.findViewById(R.id.dialogDamage);
        accu=view.findViewById(R.id.dialogAccu);
        fir=view.findViewById(R.id.dialogFire);
        mobi=view.findViewById(R.id.dialogMobili);
        tier=view.findViewById(R.id.dialogTier);
        range=view.findViewById(R.id.dialogRange);
        close=view.findViewById(R.id.dialogButton);
        name = view.findViewById(R.id.dialogName);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        for (int i = 0; i < mlist.size(); i++) {
            if (weaponName.equals(mlist.get(i).getName())){
                WeaponStats currentitem = mlist.get(i);

                name.setText(currentitem.getName());
                damage.setText("Damage : "+currentitem.getDamage());
                accu.setText("Accuracy : "+currentitem.getAccuracy());
                fir.setText("Fire Rate : "+currentitem.getFirRate());
                mobi.setText("Mobility : "+currentitem.getMobility());
                range.setText("Range : "+currentitem.getRange());
                tier.setText("Tier : "+currentitem.getTier());
                imageView.setImageResource(Id);

            }
        }

        return builder.create();
    }
}
