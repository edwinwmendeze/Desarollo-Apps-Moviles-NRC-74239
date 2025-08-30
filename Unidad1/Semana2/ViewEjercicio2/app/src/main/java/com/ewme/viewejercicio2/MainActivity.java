package com.ewme.viewejercicio2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private Button btnAccion;
    private TextView tvResultado;
    private ProgressBar progressBar;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        btnAccion = findViewById(R.id.btnAccion);
        progressBar = findViewById(R.id.progressBar);
        switch1 = findViewById(R.id.switch1);

        // Acción al presionar el botón
        btnAccion.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            Toast.makeText(this,
                    nombre.isEmpty() ? "Escribe tu nombre" : "Hola " + nombre,
                    Toast.LENGTH_SHORT).show();

            // Actualiza la barra de progreso
            progressBar.setProgress((progressBar.getProgress() + 10) % 100);
        });

        // Acción al cambiar el switch
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this,
                    isChecked ? "Notificaciones activadas" : "Notificaciones desactivadas",
                    Toast.LENGTH_SHORT).show();
        });
    }
}
