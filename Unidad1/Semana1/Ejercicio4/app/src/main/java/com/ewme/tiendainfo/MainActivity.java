package com.ewme.tiendainfo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner spProducto;
    private EditText etPrecio, etCantidad, etDescuento;
    private TextView tvResultado;
    private Button btnCalcular, btnLimpiar;

    private static final double IGV = 0.18; // 18%

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spProducto = findViewById(R.id.spProducto);
        etPrecio = findViewById(R.id.etPrecio);
        etCantidad = findViewById(R.id.etCantidad);
        etDescuento = findViewById(R.id.etDescuento);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        // Llenar productos por código (evita arrays.xml)
        String[] productos = new String[]{
                "Laptop",
                "PC de Escritorio",
                "Monitor",
                "Impresora",
                "Teclado",
                "Mouse",
                "Disco SSD",
                "Memoria RAM"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,android.R.layout.simple_spinner_item,productos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProducto.setAdapter(adapter);

        btnCalcular.setOnClickListener(v -> calcular());
        btnLimpiar.setOnClickListener(v -> limpiar());
    }

    private void calcular() {
        Double precio = parseDouble(etPrecio);
        Integer cantidad = parseInt(etCantidad);
        Double descPorc = parseDouble(etDescuento); // opcional

        if (precio == null || precio <= 0 || cantidad == null || cantidad <= 0) { 
            toast("Completa precio y cantidad válidos");
            return;
        }

        // Descuento opcional: si está vacío, se asume 0
        if (descPorc == null) descPorc = 0.0;
        if (descPorc < 0 || descPorc > 100) {
            toast("El descuento debe estar entre 0% y 100%");
            return;
        }

        double subtotal = precio * cantidad;
        double descuento = subtotal * (descPorc / 100.0);
        double subConDesc = subtotal - descuento;
        double igv = subConDesc * IGV;
        double total = subConDesc + igv;

        String producto = spProducto.getSelectedItem() == null
        ? "Producto"
        : spProducto.getSelectedItem().toString();


        String out = ""
                + "Producto: " + producto + "\n"
                + "Subtotal: " + moneda(subtotal) + "\n"
                + "Descuento (" + format2(descPorc) + "%): " + moneda(descuento) + "\n"
                + "Subtotal con descuento: " + moneda(subConDesc) + "\n"
                + "IGV (18%): " + moneda(igv) + "\n"
                + "TOTAL A PAGAR: " + moneda(total);

        tvResultado.setText(out);

    }

    private void limpiar() {
        etPrecio.setText("");
        etCantidad.setText("");
        etDescuento.setText("");
        tvResultado.setText("Resultados:");
        etPrecio.requestFocus();
    }

    // ---------- Utilidades ----------
    private Double parseDouble(EditText et) {
        String s = et.getText() == null ? "" : et.getText().toString().trim().replace(",", ".");
        if (s.isEmpty()) return null;
        try { return Double.parseDouble(s); } catch (Exception e) { return null; }
    }

    private Integer parseInt(EditText et) {
        String s = et.getText() == null ? "" : et.getText().toString().trim();
        if (s.isEmpty()) return null;
        try { return Integer.parseInt(s); } catch (Exception e) { return null; }
    }

    private String moneda(double v) {
        // Formato S/. con 2 decimales
        return String.format(Locale.getDefault(), "S/ %.2f", v);
    }

    private String format2(double v) {
        return String.format(Locale.getDefault(), "%.2f", v);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}