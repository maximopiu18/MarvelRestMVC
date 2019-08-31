package com.example.restmvc.Splash.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restmvc.R;
import com.example.restmvc.Splash.model.Constants.Constantes;
import com.example.restmvc.Splash.view.adapter.AdapterHeroes;
import com.squareup.picasso.Picasso;

public class Activity_Descripcion extends Activity {

    TextView tv_nombre, tv_realnombre, tv_peso, tv_poderes, tv_grupos, tv_habilidades;
    int posicion;
    ImageView imgHeroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe_descripcion);
        posicion = AdapterHeroes.posicionHeroe;
        imgHeroe = (ImageView)findViewById(R.id.activity_descriocion_img);
        tv_nombre = (TextView)findViewById(R.id.activity_descriocion_nombre);
        tv_realnombre = (TextView)findViewById(R.id.activity_descriocion_nombrereal);
        tv_peso = (TextView)findViewById(R.id.activity_descriocion_peso);
        tv_poderes = (TextView)findViewById(R.id.activity_descriocion_poderes);
        tv_habilidades = (TextView)findViewById(R.id.activity_descriocion_habilidades);
        tv_grupos = (TextView)findViewById(R.id.activity_descriocion_grupos);

        cargarDescripcion();
    }
    public void cargarDescripcion(){
        tv_nombre.setText(Constantes.listaHeroes.get(posicion).getName());
        tv_realnombre.setText("Nombre Real: \n"+Constantes.listaHeroes.get(posicion).getRealName());
        tv_peso.setText("Peso: \n"+Constantes.listaHeroes.get(posicion).getHeight());
        tv_poderes.setText("Poderes: \n"+Constantes.listaHeroes.get(posicion).getPower());
        tv_habilidades.setText("Habilidades: \n"+Constantes.listaHeroes.get(posicion).getAbilities());
        tv_grupos.setText("Grupos: \n" +Constantes.listaHeroes.get(posicion).getGroups());
      //  imgHeroe.setImageBitmap(Constantes.listaHeroes.get(posicion).getPhoto());

        Picasso.with(this).load(Constantes.listaHeroes.get(posicion).getPhoto())
                .resize(400,400)
                .centerInside()
                .placeholder(R.drawable.logo_marvel)
                .error(R.drawable.logo_marvel)
                .into(imgHeroe);

        //imagen por cargar
    }
}
