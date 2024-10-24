package com.cassiomacielgomes.projeto07;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoria(){
        String[] opcoes = {"pedra","papel","tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.imageView_app);
        String escolhaApp = opcoes[numeroAleatorio];

        switch(escolhaApp){
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra); //R é uma classe nativa do AndroidStudio que armazene ids informações etc.
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel); //setImageResource == setText (só que com img ao invés de txt)
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura); //R é uma classe nativa do AndroidStudio que armazene ids informações etc.
                break;
        }

        return escolhaApp;
    }

    public void verificarGanhador(String escolhaUsuario){
        System.out.println("Item clicado: " + escolhaUsuario);
    }
}