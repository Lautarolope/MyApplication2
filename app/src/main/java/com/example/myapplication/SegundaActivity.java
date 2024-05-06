package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaActivity extends Activity {

    Button btnsiguiente, btnsalir, btngmail, btntelefono, btnpagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_segunda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.cambiarPantalla();
        this.Volverlogin();
        this.gmail();
        this.telefono();
        this.Pagina();


    }

    private void cambiarPantalla() {

        btnsiguiente = findViewById(R.id.btnsiguiente);



        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), TercerActivity.class);
                    startActivity(intent);

            }
        });

    }
    private void Volverlogin() {

        btnsalir = findViewById(R.id.btnsalir);



        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
    private void gmail() {

        btngmail = findViewById(R.id.btngmail);

        btngmail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String[] direcciones = {"lautalopez2448@gmail.com"};
            String asunto = "Asunto del correo";
            Uri archivoAdjunto = null;

            composeEmail(direcciones, asunto, archivoAdjunto);
        }
    });

    }


    private void telefono() {
        btntelefono = findViewById(R.id.btntelefono);

        btntelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Numero("2954361263");
            }
        });
    }
    private void Numero(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }


    public void composeEmail(String[] addresses, String subject, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void Pagina() {
        btnpagina = findViewById(R.id.btnpagina);

        btnpagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://www.coca-cola.com/ar/es");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }



}
