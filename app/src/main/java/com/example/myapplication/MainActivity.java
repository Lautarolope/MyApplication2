package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button btningresar;
    EditText textusuario;
    EditText textcontrasena;

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

        this.PasarPantalla();
    }


    private void PasarPantalla() {
        // instancia de controles UI
        btningresar = findViewById(R.id.btnIngresar);
        textusuario = findViewById(R.id.textusuario);
        textcontrasena= findViewById(R.id.textcontrasena);


        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textusuario.getText().toString().equals("alumno")&&(textcontrasena.getText().toString().equals("1234"))) {
                    Intent intent = new Intent(getBaseContext(), SegundaActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}