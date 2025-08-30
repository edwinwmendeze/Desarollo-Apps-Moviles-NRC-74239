package com.ewme.imagenejercicio5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imgEjemplo;
    private Button btnCambiar;
    private boolean cambio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgEjemplo = findViewById(R.id.imgEjemplo);
        btnCambiar = findViewById(R.id.btnCambiar);

        btnCambiar.setOnClickListener(v -> {

            if (cambio) {
                imgEjemplo.setImageResource(R.mipmap.ic_launcher_round); // vuelve a la original
                cambio = false;
            } else {
                imgEjemplo.setImageResource(R.mipmap.ic_launcher); // otra imagen existente
                cambio = true;
            }

        });
    }
}
