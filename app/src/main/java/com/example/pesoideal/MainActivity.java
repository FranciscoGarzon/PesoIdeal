package com.example.pesoideal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText text_nombre, text_dia, text_mes, text_año, text_peso, text_estatura;
    Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_nombre = findViewById(R.id.text_nombre);
        text_dia = findViewById(R.id.text_dia);
        text_mes = findViewById(R.id.text_mes);
        text_año = findViewById(R.id.text_año);
        text_peso = findViewById(R.id.text_peso);
        text_estatura = findViewById(R.id.text_estatura);
        btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores ingresados por el usuario
                String nombre = text_nombre.getText().toString();
                int dia = Integer.parseInt(text_dia.getText().toString());
                int mes = Integer.parseInt(text_mes.getText().toString());
                int año = Integer.parseInt(text_año.getText().toString());
                double peso = Double.parseDouble(text_peso.getText().toString());
                double estatura = Double.parseDouble(text_estatura.getText().toString());

                // Calcular el IMC
                double imc = calcularIMC(peso, estatura);

                // Crear un intent para pasar datos a la segunda actividad
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("imc", imc);

                // Iniciar la segunda actividad
                startActivity(intent);
            }
        });
    }

    private double calcularIMC(double peso, double estatura) {
        // Fórmula del IMC: peso (kg) / (estatura (m) * estatura (m))
        return peso / (estatura * estatura);
    }
}