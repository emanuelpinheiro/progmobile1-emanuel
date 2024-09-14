package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1; // Código de requisição para a Activity 2
    private int contador = 1; // Inicia o contador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setText(String.valueOf(contador)); // Inicializa o botão com o valor do contador

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), MainActivity2.class);
                it.putExtra("contador", contador + 1); // Passa o contador incrementado para a segunda Activity
                startActivityForResult(it, REQUEST_CODE); // Abre a segunda Activity
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            contador = data.getIntExtra("contador", 1); // Recebe o contador da segunda Activity
            Button button = findViewById(R.id.button);
            button.setText(String.valueOf(contador)); // Atualiza o botão com o novo valor do contador
        }
    }
}
