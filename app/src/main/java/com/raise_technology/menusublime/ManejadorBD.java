package com.raise_technology.menusublime;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ManejadorBD {

    ManejadorBD()
    {

    }

    public void crearBD(Activity origen)
    {
        try
        {
            //Se crea la BD
            SQLiteDatabase  sqLiteDatabase = origen.openOrCreateDatabase("Conciertos", Context.MODE_PRIVATE,null);
            //Se crea la tabla usuarios
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (userid INTEGER PRIMARY KEY, nombre VARCHAR, correo VARCHAR, telefono VARCHAR ,contrasena VARCHAR)");
        }
        catch (Exception ex)
        {
            Toast mensaje = Toast.makeText(origen,"Error en BD "+ex.getMessage(),Toast.LENGTH_SHORT);
            mensaje.show();
        }
    }//Crear BD

    public long insertarUsuario(Activity origen, String nombre, String correo, String telefono, String contrasena)
    {
            long correcto = -1;
        try
        {
            //Se accede a la base de datos
            SQLiteDatabase  sqLiteDatabase = origen.openOrCreateDatabase("Conciertos", Context.MODE_PRIVATE,null);

            //ContentValues manejador de parametros
            ContentValues values = new ContentValues();
            values.put("nombre",nombre);
            values.put("correo",correo);
            values.put("telefono",telefono);
            values.put("contrasena",contrasena);

            //Ejecutamos el metodo de insercion
            correcto = sqLiteDatabase.insert("users",null, values);


        }
        catch (Exception ex)
        {
            Toast mensaje = Toast.makeText(origen,"Error en BD "+ex.getMessage(),Toast.LENGTH_SHORT);
            mensaje.show();
        }
        return correcto;
    }//insertar

    public boolean buscarUsuario(Activity origen, String correo, String contrasena)
    {
        boolean encontrado = false;

        try
        {
            //Se accede a la base de datos
            SQLiteDatabase  sqLiteDatabase = origen.openOrCreateDatabase("Conciertos", Context.MODE_PRIVATE,null);

            //Ejecutamos el query de busqueda
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE correo = '"+correo+"' AND contrasena = '"+contrasena+"'",null);

            if(c.getCount() > 0)
            {
                encontrado = true;
            }

        }
        catch (Exception ex)
        {
            Toast mensaje = Toast.makeText(origen,"Error en BD "+ex.getMessage(),Toast.LENGTH_SHORT);
            mensaje.show();
        }

        return encontrado;

    }//buscar

}
