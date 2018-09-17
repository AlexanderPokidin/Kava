package com.pokidin.a.kava.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pokidin.a.kava.Kava;
import com.pokidin.a.kava.R;

public class KavaAdapter extends RecyclerView.Adapter<KavaAdapter.KavaViewHolder>{

    private Kava[] mKavas;

    public KavaAdapter(Kava[] kavas){
        mKavas = kavas;
    }


    @Override
    public KavaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        return new KavaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KavaViewHolder holder, int position) {
        holder.bind(mKavas[position]);
    }

    @Override
    public int getItemCount() {
        return mKavas.length;
    }

    class KavaViewHolder extends RecyclerView.ViewHolder{
        private TextView itemName;
        private TextView itemSize;
        private TextView itemPrice;

        public KavaViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.tv_name);
            itemSize = itemView.findViewById(R.id.tv_val);
            itemPrice = itemView.findViewById(R.id.tv_price);
        }

        public void bind(Kava kava){
            itemName.setText(kava.getName());
            itemPrice.setText(kava.getPrice());
            itemSize.setText(kava.getSize());
        }
    }
}
