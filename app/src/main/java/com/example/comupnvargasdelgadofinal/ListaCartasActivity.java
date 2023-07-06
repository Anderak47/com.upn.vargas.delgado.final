package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


    }
}