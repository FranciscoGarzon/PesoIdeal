package com.example.pesoideal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView imcValue, resultado, consejosText;
    private ImageView imcImage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imcValue = findViewById(R.id.imc_value);
        resultado = findViewById(R.id.text_resultado);
        consejosText = findViewById(R.id.consejos_text);
        imcImage = findViewById(R.id.imageView2);

        // Obtener los datos pasados desde MainActivity
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        double imc = intent.getDoubleExtra("imc", 0.0);

        // Mostrar el valor del IMC en el TextView imcValue
        imcValue.setText(String.format("%.2f", imc));

        // Determinar y mostrar el resultado del IMC
        String mensajeResultado = obtenerResultadoIMC(imc);
        resultado.setText(mensajeResultado);

        // Mostrar consejos según la categoría del IMC
        String consejos = obtenerConsejosIMC(imc);
        consejosText.setText(consejos);
    }

    // Método para determinar el resultado del IMC
    private String obtenerResultadoIMC(double imc) {
        String resultadoIMC;
        if (imc < 18.5) {
            resultadoIMC = "Bajo peso";
        } else if (imc < 24.9) {
            resultadoIMC = "Peso normal";
        } else if (imc < 29.9) {
            resultadoIMC = "Sobrepeso";
        } else {
            resultadoIMC = "Obesidad";
        }
        return resultadoIMC;
    }
    private String obtenerConsejosIMC(double imc) {
        if (imc < 18.5) {
            imcImage.setImageResource(R.drawable.personasdelgadas);

            return "Consejos para personas con bajo peso: \n" +
                    "1. Consulta a un médico o dietista.\n" +
                    "2. Come más calorías de alimentos saludables.\n" +
                    "3. Fracciona las comidas en 5-6 al día.\n" +
                    "4. Incluye proteínas magras y carbohidratos saludables.\n" +
                    "5. Agrega grasas saludables.\n" +
                    "6. Evita bebidas bajas en calorías.\n" +
                    "7. Hacer ejercicios de fuerza.\n" +
                    "8. Lleva un registro de alimentos.\n" +
                    "9. Sé constante y ten paciencia.";
        } else if (imc < 24.9) {
            imcImage.setImageResource(R.drawable.personaspesonormal);
            return "Consejos para personas con peso normal: \n" +
                    "1. Come de manera equilibrada.\n" +
                    "2. Controla las porciones.\n" +
                    "3. Haz ejercicio regularmente.\n" +
                    "4. Limita alimentos procesados y azúcares.\n" +
                    "5. Duerme lo suficiente.\n" +
                    "6. Controla el estrés.\n" +
                    "7. Realiza chequeos médicos regulares.\n" +
                    "8. Mantén relaciones sociales.\n" +
                    "9. Cultiva una mentalidad positiva.";

        } else if (imc < 29.9) {
            imcImage.setImageResource(R.drawable.personasconsobrepeso);
            return "Consejos para personas con sobrepeso: \n" +
                    "1. Consulta a un profesional de la salud.\n" +
                    "2. Adopta una dieta balanceada con menos calorías.\n" +
                    "3. Controla las porciones y evita el picoteo.\n" +
                    "4. Incorpora actividad física regular en tu rutina.\n" +
                    "5. Reduce el consumo de alimentos procesados y azúcares.\n" +
                    "6. Bebe más agua y evita bebidas azucaradas.\n" +
                    "7. Controla el estrés y el sueño.\n" +
                    "8. Establece metas realistas y sigue un plan a largo plazo.\n" +
                    "9. Busca apoyo y considera un grupo de apoyo o un entrenador personal.";

        } else {
            imcImage.setImageResource(R.drawable.personasgordas);
            return "Consejos para personas con obesidad: \n" +
                    "1. Busca atención médica y asesoramiento profesional.\n" +
                    "2. Adopta una dieta equilibrada y reducida en calorías.\n" +
                    "3. Controla las porciones y evita el exceso de comida.\n" +
                    "4. Incorpora actividad física regular de acuerdo con las recomendaciones de tu médico.\n" +
                    "5. Limita el consumo de alimentos procesados, azúcares y grasas saturadas.\n" +
                    "6. Hidrátate con agua y evita bebidas azucaradas.\n" +
                    "7. Gestiona el estrés y prioriza un sueño adecuado.\n" +
                    "8. Establece metas realistas y un plan de pérdida de peso a largo plazo.\n" +
                    "9. Considera un grupo de apoyo o un profesional de la salud mental para el apoyo emocional.";

        }
    }
}
