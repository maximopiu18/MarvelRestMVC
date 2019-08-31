package com.example.restmvc.Splash.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.restmvc.Splash.Controller.Controlador;
import com.example.restmvc.R;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Controlador controlador = new Controlador(MainActivity.this);
        controlador.RestMarvel();

    }

}
