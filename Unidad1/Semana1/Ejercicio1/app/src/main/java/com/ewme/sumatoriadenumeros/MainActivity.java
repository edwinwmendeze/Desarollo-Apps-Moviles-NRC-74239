package com.ewme.sumatoriadenumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etA, etB;
    private Button btnSumar, btnLimpiar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        btnSumar = findViewById(R.id.btnSumar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        tvResultado = findViewById(R.id.tvResultado);

        btnSumar.setOnClickListener(v -> sumar());
        btnLimpiar.setOnClickListener(v -> limpiar());
    }
    private void sumar(){
        Double a = toDouble(etA);
        Double b = toDouble(etB);

        if (a==null || b== null ){
            Toast.makeText(this, "Ingresa ambos numeros mi KING", Toast.LENGTH_SHORT).show();
            return;
        }
        double r = a + b;
        // Si es entero, muestro sin decimales
        String texto = (r % 1 == 0) ? String.valueOf((long) r) : String.valueOf(r);
        tvResultado.setText("Resultado de la Suma es:  " + texto);

    }
    private void limpiar(){
        etA.setText("");
        etB.setText("");
        tvResultado.setText("Resultado de la Suma es:  ");
        etA.requestFocus();

    }
    private Double toDouble(EditText et) {
        String s = et.getText() == null ? "" : et.getText().toString().trim().replace(",", ".");
        if (s.isEmpty()) return null;
        try { return Double.parseDouble(s); } catch (Exception e) { return null; }
    }

}