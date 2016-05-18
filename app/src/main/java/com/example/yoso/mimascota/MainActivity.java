package com.example.yoso.mimascota;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Atributos
    private RecyclerView listaMascotas;
    private List<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inflar lista de mascotas
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        // Linear Layout Manager
        LinearLayoutManager llamada = new LinearLayoutManager(this);
        llamada.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llamada);

        // Inicializar datos y adaptador
        inicializarDatos();
        inicializarAdaptador();

        // Floating Button previsto para insertar fotografia de la mascota
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fotografiar mi mascota", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        // Añadir un Action Button estrella a la Action Bar
        if (id == R.id.favoritos){
            // Intent a Favoritos
            mostrarFavoritos();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // En el método acercade creamos un objeto de la clase Intent
    // y le pasamos como parámetros la referencia del objeto de esta clase (this)
    // y la referencia del otro Activity (Favoritos.class)
    //  Llamamos posteriormente al método startActivity pasando el objeto de la clase Intent
    // (con esto ya tenemos en pantalla la ventana del segundo Activity):
    public void mostrarFavoritos(){
        // Iniciando la actividad Favoritos
        Intent intent = new Intent(this, Favoritos.class);

        // Iniciar el inten
        startActivity(intent);
    }

    // Método inicializar datos
    public void inicializarDatos(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.alfie, "Alfie", "5"));
        mascotas.add(new Mascota(R.drawable.copito, "Copito", "3"));
        mascotas.add(new Mascota(R.drawable.dexter, "Dexter", "1"));
        mascotas.add(new Mascota(R.drawable.lucky, "Lucky", "2"));
        mascotas.add(new Mascota(R.drawable.mini, "Mini", "3"));
        mascotas.add(new Mascota(R.drawable.niki, "Niki", "3"));
        mascotas.add(new Mascota(R.drawable.nina, "Nina", "5"));
        mascotas.add(new Mascota(R.drawable.pinky, "Pinky", "2"));
        mascotas.add(new Mascota(R.drawable.toby, "Toby", "4"));
    }

    // Inicializa el adaptador
    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);

    }


}