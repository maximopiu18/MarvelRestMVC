package com.example.restmvc.Splash.view.adapter;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restmvc.Splash.view.Activity_Descripcion;
import com.example.restmvc.R;
import com.example.restmvc.Splash.model.ModelHeroes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterHeroes extends RecyclerView.Adapter<HolderHeroes>  {
    public static int posicionHeroe;
    private Context context;
    private ArrayList<ModelHeroes> modeloList;

    public AdapterHeroes(ArrayList<ModelHeroes> modeloList, Context context) {
        this.context = context;
        this.modeloList = modeloList;
    }

    @Override
    public HolderHeroes onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroe, parent, false);
        return new HolderHeroes(view);
    }

    @Override
    public void onBindViewHolder(final HolderHeroes holder, final int position) {


        holder.tvName.setText(modeloList.get(position).getName());
       // Log.e("TAG: ", "imgUrl :" + modelo.getDescripcion());
        Picasso.with(context).load(modeloList.get(position).getPhoto())
                .resize(200,300)
                .centerInside()
                .placeholder(R.drawable.logo_marvel)
                .error(R.drawable.logo_marvel)
                .into(holder.ivModelo);


        holder.ivModelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("position", "position: " + position);
                posicionHeroe = position;
                Intent intent = new Intent(context, Activity_Descripcion.class);
                context.startActivity(intent);



                //((Activity) context).setResult(RESULT_OK);
                //((Activity) context).finish();
                //  ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

               //   ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


  /*              Constantes.positionSuperheroe = position;
                Intent intent = new Intent(context, Activity_Description.class);
                context.startActivity(intent);*/
                //((Activity) context).setResult(RESULT_OK);
                //((Activity) context).finish();
              //  ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
    @Override
    public int getItemCount() {
        return modeloList.size(); }

}

