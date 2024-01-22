package com.MSebas55.appdivisas;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<divisasEventModel> divisasEventModel = new ArrayList<>();
    private EditText cantidadEurosEditText;
    private RecyclerView recyclerView;
    private Switch switchDescuento;
    private Button buttonConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        cantidadEurosEditText = findViewById(R.id.cantidad_euros);
        recyclerView = findViewById(R.id.divisasEventsRecycler);
        switchDescuento = findViewById(R.id.switchDescuento);
        buttonConvertir = findViewById(R.id.buttonConvertir);

        setDivisasEventModel();

        DivisasRVAdapter adapter = new DivisasRVAdapter(this, divisasEventModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        buttonConvertir.setOnClickListener(view -> convertirDivisa());
    }

    private void convertirDivisa() {
        double cantidadEuros = Double.parseDouble(cantidadEurosEditText.getText().toString());
        int divisaPosition = ((DivisasRVAdapter) recyclerView.getAdapter()).getSelectedItemPosition();
        boolean esClienteVIP = switchDescuento.isChecked();

        // Cambio de divisa
        if (divisaPosition != RecyclerView.NO_POSITION) {
            double precioDivisa = Double.parseDouble(divisasEventModel.get(divisaPosition).getDivisaPrecio());
            if (esClienteVIP) {
                precioDivisa *= 1.02;
            }
            double resultado = cantidadEuros * precioDivisa;
            TextView textViewResultado = findViewById(R.id.textViewResultado);
            textViewResultado.setText(String.valueOf(resultado));
        }
    }

    private void setDivisasEventModel() {
        String[] eventNames = getResources().getStringArray(R.array.divisas);
        String[] eventPrecio = getResources().getStringArray(R.array.precio_divisas);
        TypedArray eventIcons = getResources().obtainTypedArray(R.array.ic_divisas);

        // Ver si los arrays tienen el mismo length
        int minSize = Math.min(eventNames.length, Math.min(eventPrecio.length, eventIcons.length()));

        for (int i = 0; i < minSize; i++) {
            divisasEventModel.add(new divisasEventModel(
                    eventNames[i],
                    eventPrecio[i],
                    eventIcons.getResourceId(i, R.drawable.ic_dollar_est)
            ));
        }
        eventIcons.recycle();
    }
}
