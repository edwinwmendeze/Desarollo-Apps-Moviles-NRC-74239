package com.ewme.calcdosisvet;

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

    private Spinner spEspecie;
    private EditText etPeso, etDosisMgKg, etFrecuencia, etMgPorTableta, etMgPorMl;
    private TextView tvResultado;
    private Button btnCalcular, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spEspecie = findViewById(R.id.spEspecie);
        etPeso = findViewById(R.id.etPeso);
        etDosisMgKg = findViewById(R.id.etDosisMgKg);
        etFrecuencia = findViewById(R.id.etFrecuencia);
        etMgPorTableta = findViewById(R.id.etMgPorTableta);
        etMgPorMl = findViewById(R.id.etMgPorMl);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        // Cargar opciones del Spinner por codigo (evita @array)
        String[] especies = new String[]{"Perro", "Gato"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                especies
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEspecie.setAdapter(adapter);

        btnCalcular.setOnClickListener(v -> calcular());
        btnLimpiar.setOnClickListener(v -> limpiar());
    }

    private void calcular() {
        Double peso = parseDouble(etPeso);
        Double dosisMgKg = parseDouble(etDosisMgKg);
        Integer frecuencia = parseInt(etFrecuencia);

        if (peso == null || peso <= 0) { toast("Ingresa un peso válido (>0)"); return; }
        if (dosisMgKg == null || dosisMgKg <= 0) { toast("Ingresa una dosis valida (>0)"); return; }
        if (frecuencia == null || frecuencia < 1) { toast("Frecuencia debe ser ≥ 1"); return; }

        // Cálculos base
        double dosisTomaMg = peso * dosisMgKg;
        double dosisDiariaMg = dosisTomaMg * frecuencia;

        // Opcionales
        Double mgPorTableta = parseDouble(etMgPorTableta);
        Double mgPorMl = parseDouble(etMgPorMl);

        // Tabletas (si se ingresó mg/tab)
        String tabletasStr = "—";
        if (mgPorTableta != null && mgPorTableta > 0) {
            double t = dosisTomaMg / mgPorTableta;
            // Redondeo a 1/4 de tableta hacia arriba
            double tRed = Math.ceil(t * 4.0) / 4.0;
            tabletasStr = String.format(Locale.getDefault(), "%.2f (≈ %.2f en ¼ tab)", t, tRed);
        }

        // Volumen (si se ingresó mg/ml)
        String mlStr = "—";
        if (mgPorMl != null && mgPorMl > 0) {
            double ml = dosisTomaMg / mgPorMl;
            mlStr = String.format(Locale.getDefault(), "%.2f", ml);
        }

        // Mantenimiento hídrico (referencial)
        double mantMlDia = 60.0 * peso;

        String especie = spEspecie.getSelectedItem() != null
                ? spEspecie.getSelectedItem().toString()
                : "Perro/Gato";

        String out = ""
                + "Paciente: " + especie + " \n"
                + "Dosis por toma: " + format2(dosisTomaMg) + " mg\n"
                + "Dosis diaria total: " + format2(dosisDiariaMg) + " mg\n"
                + "Tabletas por toma: " + tabletasStr + "\n"
                + "Volumen por toma: " + mlStr + " ml\n"
                + "Mantenimiento hídrico (ref.): " + format0(mantMlDia) + " ml/día";

        tvResultado.setText(out);
    }

    private void limpiar() {
        etPeso.setText("");
        etDosisMgKg.setText("");
        etFrecuencia.setText("");
        etMgPorTableta.setText("");
        etMgPorMl.setText("");
        tvResultado.setText("Resultados:");
        etPeso.requestFocus();
    }

    // Utilidades
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

    private String format2(double v) {
        return String.format(Locale.getDefault(), "%.2f", v);
    }

    private String format0(double v) {
        return String.format(Locale.getDefault(), "%.0f", v);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}