package com.example.restmvc.Splash.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.restmvc.R;
import com.example.restmvc.Splash.model.Constants.Constantes;
import com.example.restmvc.Splash.view.adapter.AdapterHeroes;

public class ActivityLista extends Activity {
    RecyclerView recyclerView;
    AdapterHeroes adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_lista);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_heroes);
        recyclerView.setLayoutManager(new GridLayoutManager(ActivityLista.this, 1));
        adapter = new AdapterHeroes(Constantes.listaHeroes, ActivityLista.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
