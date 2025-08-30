package com.ewme.calculadorabasicaops;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResultado;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnModulo, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // <- sin EdgeToEdge ni ViewCompat

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvResultado = findViewById(R.id.tvResultado);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnModulo = findViewById(R.id.btnModulo);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        btnSumar.setOnClickListener(v -> operar(Operacion.SUMA));
        btnRestar.setOnClickListener(v -> operar(Operacion.RESTA));
        btnMultiplicar.setOnClickListener(v -> operar(Operacion.MULTIPLICACION));
        btnDividir.setOnClickListener(v -> operar(Operacion.DIVISION));
        btnModulo.setOnClickListener(v -> operar(Operacion.MODULO));
        btnLimpiar.setOnClickListener(v -> limpiar());
    }

    private enum Operacion { SUMA, RESTA, MULTIPLICACION, DIVISION, MODULO }

    private void operar(Operacion op) {
        Double a = leerNumero(etNum1);
        Double b = leerNumero(etNum2);
        if (a == null || b == null) {
            Toast.makeText(this, "Ingresa ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double res;
        String etiqueta;
        switch (op) {
            case SUMA:
                res = a + b; etiqueta = "Suma"; break;
            case RESTA:
                res = a - b; etiqueta = "Resta"; break;
            case MULTIPLICACION:
                res = a * b; etiqueta = "Multiplicación"; break;
            case DIVISION:
                if (b == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = a / b; etiqueta = "División"; break;
            case MODULO:
                if (b == 0.0) {
                    Toast.makeText(this, "No se puede hacer módulo con cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = a % b; etiqueta = "Módulo"; break;
            default:
                res = 0; etiqueta = "";
        }

        String texto = (res % 1 == 0)
                ? String.format(Locale.getDefault(), "%.0f", res)
                : String.format(Locale.getDefault(), "%.6f", res);

        tvResultado.setText("Resultado (" + etiqueta + "): " + texto);
    }

    private void limpiar() {
        etNum1.setText("");
        etNum2.setText("");
        tvResultado.setText("Resultado: ");
        etNum1.requestFocus();
    }

    private Double leerNumero(EditText et) {
        String s = et.getText() == null ? "" : et.getText().toString().trim().replace(",", ".");
        if (s.isEmpty()) return null;
        try { return Double.parseDouble(s); } catch (Exception e) { return null; }
    }
}
