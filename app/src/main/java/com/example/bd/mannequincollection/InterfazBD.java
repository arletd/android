package com.example.bd.mannequincollection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

/**
 * Created by Amanda & Arlet on 11/05/2017.
 */

public class InterfazBD {

    ConexionBD cxn;
    SQLiteDatabase bd;

    public InterfazBD(Context context){
        cxn = new ConexionBD(context);
    }

    public void open()throws SQLiteException {
        bd=cxn.getWritableDatabase();
    }

    public void close()throws SQLiteException{
        cxn.close();
    }

    public long agregarModelo(String nombre, int edad, String nacionalidad){
        ContentValues valores;
        open();
        valores= new ContentValues();
        valores.put("nombre",nombre);
        valores.put("edad", edad);
        valores.put("nacionalidad", nacionalidad);
        long res = bd.insert("modelo",null,valores);
        close();
        return res;
    }


    public Cursor listaModelos(){
        Cursor res = null;
        open();
        String query = "select nombre from modelo";
        res = bd.rawQuery(query, null);
        return res;
    }

    public Cursor buscaModelos(String nombre){
        Cursor res = null;
        open();
        String query = "select nombre from modelo where nombre like '%" + nombre + "%'";
        res = bd.rawQuery(query, null );
        return res;
    }

    public void modificarModelo(String nombreViejo, String nombre, String nacionalidad){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("nacionalidad", nacionalidad);
        bd.update("modelo", valores, "nombre =  '" + nombreViejo + "'", null);
    }


    public Cursor editorialesPorModelo(int idMod){
        Cursor res = null;
        open();
        String query = "select titulo, publicacion, mes, año from editorial where idMod = " + idMod + "order by año desc";
        res = bd.rawQuery(query, null);
        return res;
    }


    public Cursor mostrarDatosModelo(int idMod){
        Cursor res = null;
        open();
        String query = "select nombre, edad, nacionalidad from modelo where idMod = " + idMod;
        res = bd.rawQuery(query, null);
        return res;
    }


}
