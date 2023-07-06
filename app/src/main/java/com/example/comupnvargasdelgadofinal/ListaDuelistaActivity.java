package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.comupnvargasdelgadofinal.Adapters.DuelistaAdapter;
import com.example.comupnvargasdelgadofinal.DB.AppDatabase;
import com.example.comupnvargasdelgadofinal.Entitis.Duelista;
import com.example.comupnvargasdelgadofinal.Service.DuelistaDao;

import java.util.List;
import java.util.concurrent.Executors;

public class ListaDuelistaActivity extends AppCompatActivity implements DuelistaAdapter.OnCuentaClickListener{
    private RecyclerView recyclerView;
    private DuelistaAdapter duelistaAdapter;
    private DuelistaDao duelistaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_duelista);

        recyclerView = findViewById(R.id.recyclerview_duelista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener la instancia del DAO de Cuenta
        duelistaDao = AppDatabase.getInstance(getApplicationContext()).duelistaDao();

        // Obtener las cuentas registradas desde la base de datos
        obtenerDuelistasRegistradas();
    }
    private void obtenerDuelistasRegistradas() {
        // Ejecutar la operación en un hilo de fondo
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // Obtener las cuentas registradas desde la base de datos
                List<Duelista>  duelista = duelistaDao.getAllDuelista();

                // Actualizar el adaptador en el hilo principal
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Crear y configurar el adaptador de cuentas
                        duelistaAdapter = new DuelistaAdapter(duelista, ListaDuelistaActivity.this);
                        recyclerView.setAdapter(duelistaAdapter);
                    }
                });
            }
        });
    }

    @Override
    public void onCuentaClick(Duelista duelista) {

    }
}