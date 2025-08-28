package mendez.pa1.org.ui.hexbinario;

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

public class HexBinarioFragment extends Fragment {
    private EditText etHexadecimal;
    private TextView tvResultado;
    private Button btnConvertir, btnLimpiar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hex_binario, container, false);

        etHexadecimal = view.findViewById(R.id.etHexadecimal);
        tvResultado = view.findViewById(R.id.tvResultado);
        btnConvertir = view.findViewById(R.id.btnConvertir);
        btnLimpiar = view.findViewById(R.id.btnLimpiar);

        btnConvertir.setOnClickListener(v -> convertirHexBinario());
        btnLimpiar.setOnClickListener(v -> limpiar());


        return view;
    }

    private void convertirHexBinario() {
        // Validar campo vacío
        if (etHexadecimal.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Ingrese un número hexadecimal", Toast.LENGTH_SHORT).show();
            return;
        }

        String hex = etHexadecimal.getText().toString().toUpperCase();
        StringBuilder binario = new StringBuilder();

        // Convertir cada dígito hexadecimal a 4 bits binarios
        for (int i = 0; i < hex.length(); i++) {
            char digitoHex = hex.charAt(i);
            String bitsDelDigito = convertirDigitoHexABinario(digitoHex);
            binario.append(bitsDelDigito);
        }

        tvResultado.setText("Resultado: " + binario.toString());

    }

    private String convertirDigitoHexABinario(char digitoHex) {
        // Cada dígito hexadecimal = 4 bits binarios
        switch (digitoHex) {
            case '0': return "0000";
            case '1': return "0001";
            case '2': return "0010";
            case '3': return "0011";
            case '4': return "0100";
            case '5': return "0101";
            case '6': return "0110";
            case '7': return "0111";
            case '8': return "1000";
            case '9': return "1001";
            case 'A': return "1010";
            case 'B': return "1011";
            case 'C': return "1100";
            case 'D': return "1101";
            case 'E': return "1110";
            case 'F': return "1111";
            default: return "0000"; // En caso de un dígito inválido
        }
    }

    private void limpiar() {
        etHexadecimal.setText("");
        tvResultado.setText("Resultado: ");
        etHexadecimal.requestFocus();

    }
}