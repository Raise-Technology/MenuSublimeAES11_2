package com.raise_technology.menusublime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lsvMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlazamos e list view
        lsvMenu = findViewById(R.id.lsvMenu);

        //Declaramos el array list
        ArrayList<String> artistas = new ArrayList<String>();
        //agregamos los elementos
        artistas.add("Bruno Mars");
        artistas.add("Metallica");
        artistas.add("Ice Cube");
        artistas.add("Angus Young");
        artistas.add("Iron Maiden");


        //se establece un puente entre el arraylist y el listview
        ArrayAdapter<String> puente = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, artistas);
        //puenteamos el array list con el list view
        lsvMenu.setAdapter(puente);

        //controlamos el evento del clic sobre los elementos del list view

        lsvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                        Intent intent = new Intent(getApplicationContext(),ConciertoInfo.class);
                        intent.putExtra("Posicion",i);
                        startActivity(intent);




                    Toast mensaje;
                    mensaje = Toast.makeText(getApplicationContext(), lsvMenu.getItemAtPosition(i)+"", Toast.LENGTH_SHORT);
                    mensaje.show();

            }
        });






    }
}
