package com.raise_technology.menusublime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText txtNombre, txtCorreo, txtTelefono, txtContrasena;
    Button btnGuardar;
    ManejadorBD baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Se enlazan los componentes java con los componentes xml
        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnGuardar = findViewById(R.id.btnGuardar);

        //Se instancia el objeto de base de datos
        baseDatos = new ManejadorBD();

        //Se ejecuta el metodo de creacion de la base de datos
        baseDatos.crearBD(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarUsuario();
            }
        });//Evento de boton guardar
    }//onCreate

    public void insertarUsuario()
    {
        if(baseDatos.insertarUsuario(this, txtNombre.getText().toString(), txtCorreo.getText().toString(), txtTelefono.getText().toString(), txtContrasena.getText().toString()) == -1)
        {
            Toast mensaje = Toast.makeText(this,"Error al guardar",Toast.LENGTH_SHORT);
            mensaje.show();
        }
        else {
            Toast mensaje = Toast.makeText(this,"Registro completado",Toast.LENGTH_SHORT);
            mensaje.show();
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
        }
    }

}//Class
