package mendez.pa1.org.ui.areatriangulo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mendez.pa1.org.R;

public class AreaTrianguloFragment extends Fragment {
    private EditText etLado1, etLado2, etLado3;
    private TextView tvResultado;
    private Button btnCalcular, btnLimpiar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_area_triangulo, container, false);

        etLado1 = view.findViewById(R.id.etLado1);
        etLado2 = view.findViewById(R.id.etLado2);
        etLado3 = view.findViewById(R.id.etLado3);
        tvResultado = view.findViewById(R.id.tvResultado);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        btnLimpiar = view.findViewById(R.id.btnLimpiar);

        btnCalcular.setOnClickListener(v -> calcular());
        btnLimpiar.setOnClickListener(v -> limpiar());
        return view;
    }

    private void calcular(){
        // Validamos que todos los campos esten llenos
        if (etLado1.getText().toString().isEmpty() ||
                etLado2.getText().toString().isEmpty() ||
                etLado3.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtenemos los valores de los lados
        double lado1 = Double.parseDouble(etLado1.getText().toString());
        double lado2 = Double.parseDouble(etLado2.getText().toString());
        double lado3 = Double.parseDouble(etLado3.getText().toString());

        // Validamos que el triángulo válido
        if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
            Toast.makeText(getContext(), "Los lados no forman un triángulo válido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Realizamos la operación para calcular el área
        double semiperimetro = (lado1 + lado2 + lado3) / 2;
        double area = Math.sqrt(semiperimetro * (semiperimetro - lado1) * (semiperimetro - lado2) * (semiperimetro - lado3));

        // Mostramos el resultado
        tvResultado.setText("Resultado: " + String.format("%.2f", area) + " cm^2");
    }

    private void limpiar(){
        etLado1.setText("");
        etLado2.setText("");
        etLado3.setText("");
        tvResultado.setText("Resultado: ");
        etLado1.requestFocus();
    }
}