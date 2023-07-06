package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comupnvargasdelgadofinal.DB.AppDatabase;
import com.example.comupnvargasdelgadofinal.Entitis.Cartas;
import com.example.comupnvargasdelgadofinal.Service.CartasDao;

public class CrearCarta extends AppCompatActivity {

    private TextView etNombre;
    private TextView etPuntoAtaque;
    private TextView etPuntoDefensa;
    private Button btnCrearCarta;

    private long cuentaSeleccionada;
    private CartasDao cartasDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carta);

        // Obtener la cuenta seleccionada (puedes obtenerla a través de Intent o de cualquier otra forma)
        cuentaSeleccionada = getIntent().getLongExtra("cuenta_id", -1);

        // Obtener la instancia del DAO de Movimiento
        cartasDao = AppDatabase.getInstance(getApplicationContext()).cartasDao();

        // Obtener los elementos de la interfaz
        etNombre = findViewById(R.id.editNombre);
        etPuntoAtaque = findViewById(R.id.editPuntoAtaque);
        etPuntoDefensa = findViewById(R.id.editPuntoDefensa);
        btnCrearCarta = findViewById(R.id.btnCrearCarta);

        btnCrearCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipoNombre = etNombre.getText().toString().trim();
                String tipoAtaque = etPuntoAtaque.getText().toString().trim();
                String tipoDefensa = etPuntoDefensa.getText().toString().trim();

                if(!tipoNombre.isEmpty() && !tipoAtaque.isEmpty() && !tipoNombre.isEmpty()){
                    long cAtaque = Long.parseLong(tipoAtaque);
                    long cDefensa = Long.parseLong(tipoDefensa);

                    final Cartas nuevoCarta = new Cartas(
                            cuentaSeleccionada,
                            tipoNombre,
                            cAtaque,
                            cDefensa

                    );
                    AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... voids) {
                            // Insertar el movimiento en la base de datos de movimientos
                            cartasDao.insertCartas(nuevoCarta);
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            // Mostrar mensaje de éxito
                            Toast.makeText(CrearCarta.this, "Movimiento registrado exitosamente", Toast.LENGTH_SHORT).show();

                            // Limpiar los campos de texto

                        }
                    };

                    task.execute();

                }else {
                    // Mostrar mensaje de error si no se completaron todos los campos
                    Toast.makeText(CrearCarta.this, "Ingrese carta", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}