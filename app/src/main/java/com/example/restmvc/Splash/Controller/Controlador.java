package com.example.restmvc.Splash.Controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.restmvc.Splash.view.ActivityLista;
import com.example.restmvc.Splash.model.Constants.Constantes;
import com.example.restmvc.Splash.model.ModelHeroes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controlador {

    ProgressDialog progressDialog;
    Context context;
    public Controlador(Context context)
    {
        this.context = context;
    }

    public  void RestMarvel() {
        final JSONObject js = new JSONObject();
        try {
            js.put("nameSuperheroe", "");
            js.put("idHeroe", true);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                Constantes.URL_HEROES, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONArray arrayHeroes = new JSONArray();
                    arrayHeroes = response.getJSONArray("superheroes");

                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ModelHeroes>>(){}.getType();
                    Constantes.listaHeroes= gson.fromJson(arrayHeroes.toString(), type);

                }
                catch (Exception e)
                {
                    Log.e("error ", "error al convertir objetos");
                }

                if(progressDialog.isShowing())
                {
                    progressDialog.cancel();
                    Intent intent = new Intent(context, ActivityLista.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "error" + error.toString());
                if(progressDialog.isShowing())
                {
                    progressDialog.cancel();
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        queue.add(request);
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Espera un momento");
        progressDialog.setMessage("Estamos descargando la informacion perro");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.show();

    }


}
