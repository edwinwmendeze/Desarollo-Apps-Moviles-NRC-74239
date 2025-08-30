package com.ewme.navegacionejercicio4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spProducto;
    private EditText etPrecio, etCantidad;
    private RadioGroup rgEnvio;
    private Switch swDescuento;
    private Button btnProcesar;

    public static final String EXTRA_PRODUCTO = "extra_producto";
    public static final String EXTRA_SUBTOTAL = "extra_subtotal";
    public static final String EXTRA_DESCUENTO = "extra_descuento";
    public static final String EXTRA_ENVIO = "extra_envio";
    public static final String EXTRA_TOTAL = "extra_total";
    public static final String EXTRA_DESC_PORC = "extra_desc_porc"; // 0 o 10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spProducto = findViewById(R.id.spProducto);
        etPrecio = findViewById(R.id.etPrecio);
        etCantidad = findViewById(R.id.etCantidad);
        rgEnvio = findViewById(R.id.rgEnvio);
        swDescuento = findViewById(R.id.swDescuento);
        btnProcesar = findViewById(R.id.btnProcesar);

        // Llena el spinner por código
        String[] productos = {"Laptop", "Monitor", "Impresora", "Teclado", "Mouse"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, productos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProducto.setAdapter(adapter);

        // Selección por defecto
        rgEnvio.check(R.id.rbEstandar);

        btnProcesar.setOnClickListener(v -> procesar());
    }

    private void procesar() {
        Double precio = parseDouble(etPrecio);
        Integer cant = parseInt(etCantidad);

        if (precio == null || precio <= 0 || cant == null || cant <= 0) {
            Toast.makeText(this, "Completa precio y cantidad válidos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Cálculos
        double subtotal = precio * cant;
        boolean aplicaDesc = swDescuento.isChecked();
        double descPorc = aplicaDesc ? 10.0 : 0.0;
        double descuento = subtotal * (descPorc / 100.0);

        int envioSel = rgEnvio.getCheckedRadioButtonId();
        double costoEnvio = (envioSel == R.id.rbExpress) ? 15.0 : 0.0;

        double total = subtotal - descuento + costoEnvio;

        // Enviar a la segunda Activity
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra(EXTRA_PRODUCTO, spProducto.getSelectedItem().toString());
        i.putExtra(EXTRA_SUBTOTAL, subtotal);
        i.putExtra(EXTRA_DESCUENTO, descuento);
        i.putExtra(EXTRA_ENVIO, costoEnvio);
        i.putExtra(EXTRA_TOTAL, total);
        i.putExtra(EXTRA_DESC_PORC, descPorc);
        startActivity(i);
    }

    private Double parseDouble(EditText et) {
        try { return Double.parseDouble(et.getText().toString().trim().replace(",", ".")); }
        catch (Exception e) { return null; }
    }
    private Integer parseInt(EditText et) {
        try { return Integer.parseInt(et.getText().toString().trim()); }
        catch (Exception e) { return null; }
    }
}
