package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comupnvargasdelgadofinal.DB.AppDatabase;
import com.example.comupnvargasdelgadofinal.Entitis.Duelista;
import com.example.comupnvargasdelgadofinal.Service.DuelistaDao;
import com.example.comupnvargasdelgadofinal.Service.DuelistaService;
import com.example.comupnvargasdelgadofinal.Utils.RetrofitBuilder;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CrearDuelista extends AppCompatActivity {
    private EditText etNombreDuelista;
    private Button btnRegistrarDuelista;
    private DuelistaDao duelistaDao;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_duelista);

        etNombreDuelista = findViewById(R.id.et_nombre_duelista);
        btnRegistrarDuelista = findViewById(R.id.btn_registrar_duelista);

        // Obtener la instancia del DAO de Cuenta
        duelistaDao = AppDatabase.getInstance(getApplicationContext()).duelistaDao();

        btnRegistrarDuelista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreDuelista = etNombreDuelista.getText().toString().trim();
                if (!nombreDuelista.isEmpty()) {

                    Duelista duelista = new Duelista(nombreDuelista);

                    // Guardar la cuenta en la base de datos
                    guardarDuelista(duelista);

                    Toast.makeText(CrearDuelista.this, "crear duelista", Toast.LENGTH_SHORT).show();
                    etNombreDuelista.setText("");
                }
                
            }
        });
    }
    private void guardarDuelista(final Duelista duelista) {
        // Ejecutar la operación en un hilo de fondo
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // Insertar la cuenta en la base de datos
                duelistaDao.insertDuelista(duelista);
            }
        });
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}