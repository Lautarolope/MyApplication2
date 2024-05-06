package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TercerActivity extends Activity {

    Button btnpantallaprincipal,btncontacto,btngmailprogramador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tercer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.Volverlogin();
        this.telefonoprogramador();
        this.gmailprogramador();
    }


    private void Volverlogin() {

        btnpantallaprincipal = findViewById(R.id.btnpantallaprincipal);



        btnpantallaprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SegundaActivity.class);
                startActivity(intent);

            }
        });

    }

    private void telefonoprogramador() {
        btncontacto = findViewById(R.id.btncontacto);

        btncontacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Numero1("2954321263"); //numero inventado
            }
        });
    }
    private void Numero1(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    private void gmailprogramador() {

        btngmailprogramador = findViewById(R.id.btngmailprogramador);

        btngmailprogramador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] direcciones = {"lautalopez2448@gmail.com"};
                String asunto = ""; //
                Uri archivoAdjunto = null; //

                composeEmail(direcciones, asunto, archivoAdjunto);
            }
        });

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

}
