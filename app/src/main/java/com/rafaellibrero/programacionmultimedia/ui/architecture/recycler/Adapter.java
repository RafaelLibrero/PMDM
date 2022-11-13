package com.rafaellibrero.programacionmultimedia.ui.architecture.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaellibrero.programacionmultimedia.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList<Arquitectura> list;
    private final Context mContext;

    public Adapter(ArrayList<Arquitectura> list, Context context) {
        this.list = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_architecture, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.numColegiado.setText(mContext.getString(R.string.arch_numColegiado, list.get(position).getNumColegiado()));
        holder.nombre.setText(mContext.getString(R.string.arch_nombre, list.get(position).getNombre()));
        holder.especialidad.setText(mContext.getString(R.string.arch_especialidad, list.get(position).getEspecialidad()));
        holder.estaActivo.setText(mContext.getString(R.string.arch_estaActivo, list.get(position).getEstaActivo()));
        holder.fechaNacimiento.setText(mContext.getString(R.string.arch_fechaNacimiento, list.get(position).getFechaNacimiento()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView numColegiado;
        private TextView nombre;
        private TextView especialidad;
        private TextView estaActivo;
        private TextView fechaNacimiento;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            numColegiado = itemView.findViewById(R.id.tvNumColegiado);
            nombre = itemView.findViewById(R.id.tvNombre);
            especialidad = itemView.findViewById(R.id.tvEspecialidad);
            estaActivo = itemView.findViewById(R.id.tvEstaActivo);
            fechaNacimiento = itemView.findViewById(R.id.tvFechaNacimiento);
        }
    }

}
