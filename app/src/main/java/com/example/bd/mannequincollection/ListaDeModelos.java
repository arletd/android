package com.example.bd.mannequincollection;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

public class ListaDeModelos extends AppCompatActivity {

    Button reg;
    InterfazBD iBD;
    ListView lv;
    ArrayList<String> modelitos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_modelos);
        reg = (Button) findViewById(R.id.btVolver);
        lv = (ListView) findViewById(R.id.listaModelos);
        traerDatos();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, modelitos);
        lv.setAdapter(adaptador);
        /*lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaDeModelos.this, PerfilModelo.class);
                String message = "abc";
                String text= lv.getSelectedItem().toString();
                intent.putExtra(text, message);
                startActivity(intent);
            }
        });*/

    }

    public void regresar (View v) {
        Intent intent = new Intent(ListaDeModelos.this, Modelos.class);
        startActivity(intent);
    }

    public void traerDatos(){
        iBD = new InterfazBD(this);
        Cursor c = iBD.listaModelos();
        if(c.moveToFirst()){
            do{
                modelitos.add(c.getString(c.getColumnIndex("nombre")));
            } while(c.moveToNext());
        }
    }


}
