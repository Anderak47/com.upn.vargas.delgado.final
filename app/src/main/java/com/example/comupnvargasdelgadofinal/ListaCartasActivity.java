package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.comupnvargasdelgadofinal.Adapters.CartasAdapter;
import com.example.comupnvargasdelgadofinal.DB.AppDatabase;
import com.example.comupnvargasdelgadofinal.Entitis.Cartas;
import com.example.comupnvargasdelgadofinal.Service.CartasDao;

import java.util.ArrayList;
import java.util.List;

public class ListaCartasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartasAdapter cartasAdapter;
    private List<Cartas> listaCartas;
    private CartasDao cartasDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cartas);

        // Obtén la instancia del DAO de Movimiento
        cartasDao = AppDatabase.getInstance(getApplicationContext()).cartasDao();

        // Inicializa la lista de movimientos
        listaCartas = new ArrayList<>();

        // Inicializa el RecyclerView
        recyclerView = findViewById(R.id.recycler_cartas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartasAdapter = new CartasAdapter(listaCartas);
        recyclerView.setAdapter(cartasAdapter);

        long dueistaId = getIntent().getLongExtra("dueistaId", -1);
        cargarCartas(dueistaId);

    }
    private void cargarCartas(final long duelistaId) {
        AsyncTask<Void, Void, List<Cartas>> task = new AsyncTask<Void, Void, List<Cartas>>() {
            @Override
            protected List<Cartas> doInBackground(Void... voids) {
                return cartasDao.getDuelistaByDuelistaId(duelistaId);
            }

            @Override
            protected void onPostExecute(List<Cartas> movimientos) {
                // Actualiza la lista de movimientos con los datos obtenidos de la base de datos
                listaCartas.clear();
                listaCartas.addAll(movimientos);

                // Notifica al adaptador que los datos han cambiado
                cartasAdapter.notifyDataSetChanged();
            }
        };

        task.execute();
    }
}