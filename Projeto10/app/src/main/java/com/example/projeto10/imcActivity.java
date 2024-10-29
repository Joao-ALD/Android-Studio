package com.example.projeto10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class imcActivity extends AppCompatActivity {

    private TextInputEditText edPeso, edAltura;
    private Button btCalc, btLimp;
    double imc, peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);

        edPeso   = findViewById(R.id.input_peso);
        edAltura = findViewById(R.id.input_altura);
        btCalc   = findViewById(R.id.button_Calcular);
        btLimp   = findViewById(R.id.button_Limpar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularIMC(View view){
        String alturaStr = edAltura.getText().toString();
        String pesoStr = edPeso.getText().toString();

        if (pesoStr.isEmpty()|| pesoStr == "" || alturaStr == "" || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        peso = Double.parseDouble(pesoStr);
        altura = Double.parseDouble(alturaStr);

        //peso = (Double.parseDouble(edPeso.getText().toString()));
        //altura = (Double.parseDouble(edAltura.getText().toString()));

        altura = altura /100;
        imc = peso / (altura * altura);

        if(imc < 17){
            //padrão para exibir um alerta:
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de: "+ imc +" - MUITO ABAIXO DO PESO");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();
        }
        else if (imc >= 17 && imc < 18.5){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de: "+ imc +" - ABAIXO DO PESO");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();
        }
        else if (imc >= 18.5 && imc < 25){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de: "+ imc +" - PESO NORMAL");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();
        }
        else if (imc >= 25 && imc < 30){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de: "+ imc +" - ACIMA DO PESO");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();
        }
        else if (imc >= 30 && imc < 18.5){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de: "+ imc +" - MUITO ACIMA DO PESO");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();
        }

    }

}