package mendez.pa1.org.ui.binariodecimal;

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

public class BinarioDecimalFragment extends Fragment {
    private EditText etBinario;
    private TextView tvResultado;
    private Button btnConvertir, btnLimpiar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_binario_decimal, container, false);

        etBinario = view.findViewById(R.id.etBinario);
        tvResultado = view.findViewById(R.id.tvResultado);
        btnConvertir = view.findViewById(R.id.btnConvertir);
        btnLimpiar = view.findViewById(R.id.btnLimpiar);

        btnConvertir.setOnClickListener(v -> convertirBinarioDecimal());
        btnLimpiar.setOnClickListener(v -> limpiar());

        return view;
    }

    private void convertirBinarioDecimal() {
        // Validamos que el campo no esté vacío
        if (etBinario.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Ingrese un número binario", Toast.LENGTH_SHORT).show();
            return;
        }
        String binario = etBinario.getText().toString();
        int decimal = 0;

        for (int i = 0; i < binario.length(); i++) {
            char bit = binario.charAt(binario.length() - 1 - i);
            if (bit == '1') {
                decimal += Math.pow(2, i);
            }
        }
        tvResultado.setText("Resultado: " + decimal);

    }

    private void limpiar() {
        etBinario.setText("");
        tvResultado.setText("Resultado: ");
        etBinario.requestFocus();
    }
}