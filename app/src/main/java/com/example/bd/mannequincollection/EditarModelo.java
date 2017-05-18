package com.example.bd.mannequincollection;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditarModelo extends AppCompatActivity {

    Button reg, cambios;
    Spinner nombres, nacionalidad;
    EditText nuevo;
    InterfazBD iBD;
    ArrayList<String> modelitos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_modelo);
        iBD = new InterfazBD(this);
        reg = (Button) findViewById(R.id.btVolver);
        cambios = (Button) findViewById(R.id.btCambios);
        nombres = (Spinner) findViewById(R.id.nombres);
        nacionalidad = (Spinner) findViewById(R.id.nacionalidad);
        nuevo = (EditText) findViewById(R.id.nomNuevo);
        traerDatos();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, modelitos);
        nombres.setAdapter(adaptador);
    }

    public void regresar (View v) {
        Intent intent = new Intent(EditarModelo.this, Modelos.class);
        startActivity(intent);
    }

    public void traerDatos(){
        Cursor c = iBD.listaModelos();
        if(c.moveToFirst()){
            do{
                modelitos.add(c.getString(c.getColumnIndex("nombre")));
            } while(c.moveToNext());
        }
    }

    public void modificar(View v){
        String nom = nuevo.getText().toString();
        if(nom.equals("")){
            Toast.makeText(this, "Por favor introduce un nombre", Toast.LENGTH_LONG).show();
        }
        else {
            String viejo = nombres.getSelectedItem().toString();
            String nac = nacionalidad.getSelectedItem().toString();
            iBD.modificarModelo(viejo, nom, nac);
            Toast.makeText(this, "Cambios realizados", Toast.LENGTH_LONG).show();
            nuevo.setText("");
            nombres.setSelection(0);
            nacionalidad.setSelection(0);
            }
    }

}
