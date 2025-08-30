package com.ewme.navegacionejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    private TextView tvProducto, tvSubtotal, tvDescuento, tvEnvio, tvTotal;
    private ProgressBar progDescuento;
    private Button btnCompartir, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvProducto = findViewById(R.id.tvProducto);
        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvDescuento = findViewById(R.id.tvDescuento);
        tvEnvio = findViewById(R.id.tvEnvio);
        tvTotal = findViewById(R.id.tvTotal);
        progDescuento = findViewById(R.id.progDescuento);
        btnCompartir = findViewById(R.id.btnCompartir);
        btnVolver = findViewById(R.id.btnVolver);

        // Recibe datos
        Intent i = getIntent();
        String producto = i.getStringExtra(MainActivity.EXTRA_PRODUCTO);
        double subtotal = i.getDoubleExtra(MainActivity.EXTRA_SUBTOTAL, 0);
        double descuento = i.getDoubleExtra(MainActivity.EXTRA_DESCUENTO, 0);
        double envio = i.getDoubleExtra(MainActivity.EXTRA_ENVIO, 0);
        double total = i.getDoubleExtra(MainActivity.EXTRA_TOTAL, 0);
        double descPorc = i.getDoubleExtra(MainActivity.EXTRA_DESC_PORC, 0);

        // Muestra
        tvProducto.setText("Producto: " + producto);
        tvSubtotal.setText(String.format(Locale.getDefault(), "Subtotal: S/ %.2f", subtotal));
        tvDescuento.setText(String.format(Locale.getDefault(), "Descuento: S/ %.2f", descuento));
        tvEnvio.setText(String.format(Locale.getDefault(), "Envío: S/ %.2f", envio));
        tvTotal.setText(String.format(Locale.getDefault(), "TOTAL: S/ %.2f", total));
        progDescuento.setProgress((int) Math.round(descPorc));

        // Compartir
        btnCompartir.setOnClickListener(v -> {
            String texto = "Compra de " + producto + "\n" +
                    String.format(Locale.getDefault(), "Subtotal: S/ %.2f\n", subtotal) +
                    String.format(Locale.getDefault(), "Descuento: S/ %.2f\n", descuento) +
                    String.format(Locale.getDefault(), "Envío: S/ %.2f\n", envio) +
                    String.format(Locale.getDefault(), "TOTAL: S/ %.2f", total);
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, texto);
            startActivity(Intent.createChooser(share, "Compartir resumen"));
        });

        // Volver
        btnVolver.setOnClickListener(v -> finish());
    }
}

