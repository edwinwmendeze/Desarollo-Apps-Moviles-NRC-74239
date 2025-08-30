package com.ewme.viewejercicio1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private TextView tvResultado;
    private Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        tvResultado = findViewById(R.id.tvResultado);
        btnSaludar = findViewById(R.id.btnSaludar);

        btnSaludar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                tvResultado.setText("Por favor ingresa tu nombre");
            } else {
                tvResultado.setText("¡Hola, " + nombre + "!");
            }
        });
    }
}
