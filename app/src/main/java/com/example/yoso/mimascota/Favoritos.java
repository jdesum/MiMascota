package com.example.yoso.mimascota;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


/**
 * Created by yoso on 19/05/16.
 */
public class Favoritos extends AppCompatActivity {

    // Atributos
    private RecyclerView listaMascotas;
    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Navegación regreso
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);



        //Inflar lista de mascotas
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);


        // Linear Layout Manager
        LinearLayoutManager llamada = new LinearLayoutManager(this);
        llamada.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llamada);

        // Inicializar datos y adaptador
        inicializarDatos();
        inicializarAdaptador();


    }


    // Método inicializar datos
    public void inicializarDatos(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.copito, "Copito", "3"));
        mascotas.add(new Mascota(R.drawable.alfie, "Alfie", "5"));
        mascotas.add(new Mascota(R.drawable.lucky, "Lucky", "2"));
        mascotas.add(new Mascota(R.drawable.niki, "Niki", "3"));
        mascotas.add(new Mascota(R.drawable.toby, "Toby", "4"));
    }

    // Inicializa el adaptador
    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);

    }



}