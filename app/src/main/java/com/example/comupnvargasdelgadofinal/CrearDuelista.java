package com.example.comupnvargasdelgadofinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comupnvargasdelgadofinal.DB.AppDatabase;
import com.example.comupnvargasdelgadofinal.Entitis.Duelista;
import com.example.comupnvargasdelgadofinal.Service.DuelistaDao;

public class CrearDuelista extends AppCompatActivity {
    private EditText etNombreDuelista;
    private Button btnRegistrarDuelista;
    private DuelistaDao duelistaDao;
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

                    Duelista cuenta = new Duelista(nombreDuelista);

                    // Guardar la cuenta en la base de datos
                    //guardarCuenta(cuenta);

                    Toast.makeText(CrearDuelista.this, "crear duelista", Toast.LENGTH_SHORT).show();
                    etNombreDuelista.setText("");
                } else {

                    Toast.makeText(CrearDuelista.this, "Ingrese un nombre duelista", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}