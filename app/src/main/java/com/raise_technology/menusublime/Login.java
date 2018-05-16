package com.raise_technology.menusublime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txtCorreo, txtContrasena;
    Button btnLogin, btnRegistrarse;
    ManejadorBD baseDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ligamos los elementos java con xml
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        baseDatos = new ManejadorBD();

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventoRegistro();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar();
            }
        });

    }//onCreate

    public void eventoRegistro()
    {
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);

    }

    public void ingresar()
    {
        if(baseDatos.buscarUsuario(this, txtCorreo.getText().toString(), txtContrasena.getText().toString()))
        {
            Toast mensaje = Toast.makeText(this,"Bienvenido",Toast.LENGTH_SHORT);
            mensaje.show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast mensaje = Toast.makeText(this,"Error de autenticacion",Toast.LENGTH_SHORT);
            mensaje.show();

        }
    }

}//Class
