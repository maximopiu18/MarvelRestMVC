package com.example.restmvc.Splash.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restmvc.R;

public class HolderHeroes extends RecyclerView.ViewHolder {

    ImageView ivModelo;
    TextView tvName;
    public HolderHeroes(View itemView) {
        super(itemView);
        ivModelo = (ImageView) itemView.findViewById(R.id.item_image);
        tvName = (TextView) itemView.findViewById(R.id.item_name);
    }
    
}
