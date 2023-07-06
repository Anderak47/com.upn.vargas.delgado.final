package com.example.comupnvargasdelgadofinal.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnvargasdelgadofinal.Entitis.Cartas;
import com.example.comupnvargasdelgadofinal.R;

import java.util.List;

public class CartasAdapter extends RecyclerView.Adapter<CartasAdapter.CartasViewHolder>{
    private List<Cartas> cartas;

    public CartasAdapter(List<Cartas> cartas) {

        this.cartas = cartas;
    }

    public void setMovimientos(List<Cartas> cartas) {

        this.cartas = cartas;
    }
    @NonNull
    @Override
    public CartasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartas, parent, false);
        return new CartasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartasViewHolder holder, int position) {

        Cartas carta = cartas.get(position);
        holder.tvNombreCarta.setText(carta.getNombre());
        holder.tvPuntoAtaque.setText(String.valueOf(carta.getPuntoAtaque()));
        holder.tvPuntoDefensa.setText(String.valueOf(carta.getPuntoDefensa()));

    }

    @Override
    public int getItemCount() {
        return cartas.size();
    }

    static class CartasViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreCarta;
        TextView tvPuntoAtaque;
        TextView tvPuntoDefensa;


        public CartasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCarta = itemView.findViewById(R.id.txtNombre);
            tvPuntoAtaque = itemView.findViewById(R.id.txtPuntoAtaque);
            tvPuntoDefensa = itemView.findViewById(R.id.txtPuntoDefensa);
        }
    }
}
