package mendez.pa1.org.ui.numeroaleatorio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

import mendez.pa1.org.R;

public class NumeroAleatorioFragment extends Fragment {
    private TextView tvNumeroGenerado ,tvResultado;
    private Button btnGenerar, btnLimpiar;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numero_aleatorio, container, false);

        tvNumeroGenerado = view.findViewById(R.id.tvNumeroGenerado);
        tvResultado = view.findViewById(R.id.tvResultado);
        btnGenerar = view.findViewById(R.id.btnGenerar);
        btnLimpiar = view.findViewById(R.id.btnLimpiar);

        btnGenerar.setOnClickListener(v -> generarNumero());
        btnLimpiar.setOnClickListener(v -> limpiar());

        return view;
    }

    private void generarNumero(){
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000);

        int contadorImpares = contarImpares(numero);

        // Mostrar número
        tvNumeroGenerado.setText("Número generado: " + numero);

        // Mostrar resultado
        if (contadorImpares == 3) {
            tvResultado.setText("Es correcto!");
        } else {
            tvResultado.setText("No es correcto! \n(Tiene " + contadorImpares + " impares, necesita 3)");
        }
    }

    private int contarImpares(int numero) {
        int contador = 0;
        while (numero > 0) {
            int digito = numero % 10;
            if (digito % 2 != 0) {
                contador++;
            }
            numero /= 10;
        }
        return contador;
    }

    private void limpiar(){
        tvNumeroGenerado.setText("Número generado: ");
        tvResultado.setText("Resultado: ");
    }
}