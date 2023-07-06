package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistrarDuelista;
    private Button btnVerDetalleDuelista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrarDuelista = findViewById(R.id.btn_registrar_duelista);
        btnVerDetalleDuelista = findViewById(R.id.btn_ver_lista_main);

        btnRegistrarDuelista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrearDuelista.class);
                startActivity(intent);

            }
        });

        btnVerDetalleDuelista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaDuelistaActivity.class);
                startActivity(intent);
            }
        });
    }
}