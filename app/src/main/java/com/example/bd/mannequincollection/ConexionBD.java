package com.example.bd.mannequincollection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amanda & Arlet on 11/05/2017.
 */

public class ConexionBD extends SQLiteOpenHelper {

    String createModelo="create table if not exists modelo(idMod integer primary key autoincrement, nombre text not null, edad integer not null, nacionalidad text not null)";
    String createEditorial="create table if not exists editorial(idEdi integer primary key autoincrement, titulo text not null, publicacion text not null, mes text not null, año integer not null, director text not null, FOREIGN KEY(nombreMod) REFERENCES modelo(nombre))";

    public ConexionBD(Context context) {
        super(context, "mannequin.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createModelo);
        db.execSQL(createEditorial);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String updateModelo="drop table if exists modelo";
        String updateEditorial="drop table if exists editorial";
        db.execSQL(updateModelo);
        db.execSQL(updateEditorial);
        onCreate(db);
    }
}
