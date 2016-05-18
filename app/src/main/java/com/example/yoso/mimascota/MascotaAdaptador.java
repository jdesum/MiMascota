package com.example.yoso.mimascota;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by yoso on 19/05/16.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    // Declarar una lista de mascotas
    private List<Mascota> mascotas;
    private Activity activity;

    // Constructor
    public MascotaAdaptador(List<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Clase ViewHolder inner class
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        // Declarar los atributos de los view: imagen_mascota, tvNombreMascota y
        // tvValoracion
        private ImageView imagen_mascota;
        private TextView tvNombreMascota;
        private TextView tvValoracion;
        // Agregar el botón Like
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            // Declarar los views que le pase datos
            imagen_mascota = (ImageView) itemView.findViewById(R.id.imagen_mascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvValoracion = (TextView) itemView.findViewById(R.id.tvValoracion);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);



        }
    }

    // Métodos creados por el adaptador

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflar el layout tarjeta
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_detalle, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imagen_mascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvValoracion.setText(mascota.getRaiting());

        // Detalle de la mascota
        mascotaViewHolder.imagen_mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        // Agregado onClickListener para el botón blanco de Like
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Me gusta " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

   /* @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imagen_mascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvValoracion.setText(mascota.getRaiting());

    } */

    @Override
    public int getItemCount() {
        // Cantidad de elementos de la lista
        return mascotas.size();
    }


}
