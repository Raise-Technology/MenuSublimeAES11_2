package com.raise_technology.menusublime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConciertoInfo extends AppCompatActivity {
    ImageView imgArtista;
    Button btnBoletos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concierto_info);

        //Enlazamos el imageView
        imgArtista = findViewById(R.id.imgArtista);
        btnBoletos = findViewById(R.id.btnBoletos);

        //Se obtienen los parametros del intent
        Intent intent = getIntent();
        int indiceArtista = intent.getIntExtra("Posicion",-1);

        //Se evalua cual artista debemos mostrar


        switch(indiceArtista)
        {
            case 0:
                imgArtista.setImageResource(R.drawable.brunomars);
                break;
            case 1:
                imgArtista.setImageResource(R.drawable.metallica);
                break;
            case 2:
                imgArtista.setImageResource(R.drawable.icecube);
                break;
            case 3:
                imgArtista.setImageResource(R.drawable.angusyoung);
                break;
            case 4:
                imgArtista.setImageResource(R.drawable.ironmaiden);
                break;
        }

        btnBoletos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boletos();
            }
        });
    }

    public void boletos()
    {
        Intent intent = new Intent(this,Pago.class);
        startActivity(intent);
    }
}
