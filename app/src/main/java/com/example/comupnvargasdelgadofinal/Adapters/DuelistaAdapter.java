package com.example.comupnvargasdelgadofinal.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comupnvargasdelgadofinal.CrearCarta;
import com.example.comupnvargasdelgadofinal.Entitis.Duelista;
import com.example.comupnvargasdelgadofinal.R;

import java.util.List;

public class DuelistaAdapter extends RecyclerView.Adapter<DuelistaAdapter.DealistaViewHolder>{
    private List<Duelista> duelistas;
    private OnCuentaClickListener listener;
    private Button btncrearCarta;
    private Button btnverDetalle;

    public DuelistaAdapter(List<Duelista> duelistas, OnCuentaClickListener listener) {
        this.duelistas = duelistas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DealistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_duelista, parent, false);
        return new DealistaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealistaViewHolder holder, int position) {
        Duelista duelista = duelistas.get(position);
        holder.bind(duelista);
    }

    @Override
    public int getItemCount() {
        return duelistas.size();
    }

    public class DealistaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtNombreDuelista;

        public DealistaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombreDuelista = itemView.findViewById(R.id.txt_nombre_duelista);
            itemView.setOnClickListener(this);


        }

        public void bind(Duelista duelista) {

            txtNombreDuelista.setText(duelista.getNombre());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Duelista duelista = duelistas.get(position);
                listener.onCuentaClick(duelista);
            }
        }
    }

    public interface OnCuentaClickListener {
        void onCuentaClick(Duelista duelista);
    }
}
