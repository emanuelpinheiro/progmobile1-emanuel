package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = new Button(this);
        setContentView(button); // Define o botão como o conteúdo da tela

        // Obtém o contador da Intent
        contador = getIntent().getIntExtra("contador", 1);
        button.setText(String.valueOf(contador)); // Define o texto do botão

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("contador", contador + 1); // Incrementa o contador e o retorna
                setResult(RESULT_OK, returnIntent); // Envia o resultado de volta para a MainActivity
                finish(); // Fecha a Activity atual
            }
        });
    }
}
