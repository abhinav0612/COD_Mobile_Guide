package com.deathalurer.codmobileguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.deathalurer.codmobileguide.Fragments.CustomAttachmentDialgoFragment;

import java.util.List;

/**
 * Created by Abhinav Singh on 05,October,2019
 */
public class CustomAtachmentAdapter extends RecyclerView.Adapter<CustomAtachmentAdapter.CustomViewHolder> {
    private List<Recycler_Item> mList;
    private Fragment fragment;

    public CustomAtachmentAdapter(List<Recycler_Item> mList, Fragment context) {
        this.mList = mList;
        this.fragment = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        holder.textView.setText(mList.get(position).getName());
        holder.imageView.setImageResource(mList.get(position).getImageResId());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recycler_Item item = mList.get(position);
                CustomAttachmentDialgoFragment dialgoFragment = new CustomAttachmentDialgoFragment(item.getName(),
                        item.getImageResId(),item.getDesc(),item.getAccu(),item.getRange());
                dialgoFragment.show(fragment.getActivity().getSupportFragmentManager(),"");

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private CardView cardView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_item);
            textView = itemView.findViewById(R.id.item_text);
            cardView = itemView.findViewById(R.id.cardViewItem);
        }
    }

}
