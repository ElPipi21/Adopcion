package com.proyectofinal.adopcioncolitas.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyectofinal.adopcioncolitas.Clases.Mascota;
import com.proyectofinal.adopcioncolitas.R;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotaViewHolder> implements View.OnClickListener {

    ArrayList<Mascota> listaMascota;
    private View.OnClickListener listener;

    public  MascotasAdapter(ArrayList<Mascota> listaMascota){

        this.listaMascota=listaMascota;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {



        holder.txtNombre.setText(listaMascota.get(position).getNombre());
        holder.txtEspecie.setText(listaMascota.get(position).getEspecie());
        holder.txtCiudad.setText(listaMascota.get(position).getCiudad());
        holder.foto.setImageResource(listaMascota.get(position).getImagenId());


    }

    @Override
    public int getItemCount() {
        return listaMascota.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }


    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtEspecie,txtCiudad;
        ImageView foto;

        public MascotaViewHolder( View itemView) {
            super(itemView);
            txtNombre= itemView.findViewById(R.id.txtNombres);
            txtCiudad= itemView.findViewById(R.id.txtCiudad);
            txtEspecie=itemView.findViewById(R.id.txtEspecie);
            foto= itemView.findViewById(R.id.idimagen);
        }
    }
}
