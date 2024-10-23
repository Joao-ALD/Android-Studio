package com.example.projeto06;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    String[] frases = {
            "Cada novo dia é uma oportunidade para recomeçar; aproveite-o para realizar seus sonhos",
            "Acredite em si mesmo e nas suas capacidades; você é mais forte do que imagina",
            "Desafios são apenas oportunidades disfarçadas; enfrente-os com coragem e saia mais forte"
    };

    public void gerarFrase(View view){
        TextView texto = findViewById(R.id.text_result);
        int numeroAleatorio = new Random().nextInt(3); //new = instanciar ( significa que em algum lugar é um bloco de códigos prontos, que ao instanciar vc pode manipular neste código)

        String frase = frases[numeroAleatorio];

        texto.setText(frase);
    }

    public void exiirTodas(View view){
        TextView texto = findViewById(R.id.text_result);

        String textoResultado = "";

        for(String frase : frases){
              textoResultado = textoResultado + frase + "\n \n";
        };

        texto.setText(textoResultado);
    }
}