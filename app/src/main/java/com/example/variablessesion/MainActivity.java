package com.example.variablessesion;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText caja;
    Button btnmostrar, btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;

        final SharedPreferences archivo = getSharedPreferences("Variables", context.MODE_PRIVATE);

        btnguardar = findViewById(R.id.btn_guardar);
        btnmostrar = findViewById(R.id.btn_mostrar);
        caja = findViewById(R.id.edi_text_1);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = archivo.edit();
                editor.putString("variable", caja.getText().toString());
                editor.commit();

            }
        });

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = archivo.getString("variable" , "nachos");
                btnmostrar.setText(dato);
            }
        });
    }
}
