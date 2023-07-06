package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleDuelistaMain extends AppCompatActivity {
    private TextView tvNombre;
    private Button btnRegistrarCarta;
    private Button btnVerDetalle;
    long duelistaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_duelista_main);

        tvNombre = findViewById(R.id.txtnombreDuelistaa);
        btnRegistrarCarta = findViewById(R.id.btn_registrarCarta);
        btnVerDetalle = findViewById(R.id.btn_ver_Cartass);

        // Simplemente mostraremos el nombre de la cuenta en el TextView de nombre
        String nombreDuelista = getIntent().getStringExtra("nombreduelista"); // Reemplaza con el nombre de la cuenta seleccionada
        tvNombre.setText(nombreDuelista);

        // Obtener el ID de la cuenta seleccionada
        duelistaId = getIntent().getLongExtra("duelistaID", -1);

        btnRegistrarCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleDuelistaMain.this, CrearCarta.class);

                // Pasa el cuentaId como extra en el Intent
                intent.putExtra("cuenta_id", duelistaId);

                // Inicia la actividad RegistroMovimientoActivity
                startActivity(intent);

                // Muestra un mensaje o realiza otras acciones si es necesario
                Toast.makeText(DetalleDuelistaMain.this, "Registrar duelista", Toast.LENGTH_SHORT).show();
            }
        });

        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad ListaMovimientosActivity y pasar el cuentaId
                Intent intent = new Intent(DetalleDuelistaMain.this, DetalleDuelistaMain.class);
                intent.putExtra("cuenta_id", duelistaId);
                startActivity(intent);
                Toast.makeText(DetalleDuelistaMain.this, "Ver movimientos", Toast.LENGTH_SHORT).show();

            }
        });
    }
}