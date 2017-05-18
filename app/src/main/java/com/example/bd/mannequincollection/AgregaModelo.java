package com.example.bd.mannequincollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregaModelo extends AppCompatActivity {

    EditText nombre;
    Spinner edad, nacionalidad;
    Button regresar, agregar;
    InterfazBD iBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrega_modelo);
        regresar = (Button) findViewById(R.id.btVolver);
        agregar = (Button) findViewById(R.id.btAgregarModelo);
        nombre = (EditText) findViewById(R.id.registraNombre);
        nacionalidad = (Spinner) findViewById(R.id.registraNacionalidad);
        edad = (Spinner) findViewById(R.id.registraEdad);
    }

    public void regresar (View v){
        Intent intent = new Intent(AgregaModelo.this, Modelos.class);
        startActivity(intent);
    }

    public void agregar(View v){
        iBD = new InterfazBD(this);
        String nom = nombre.getText().toString();
        String nac = nacionalidad.getSelectedItem().toString();
        int ed = Integer.parseInt(edad.getSelectedItem().toString());
        long res = iBD.agregarModelo(nom, ed, nac);
        Toast.makeText(this, "Se agregó la modelo " + res, Toast.LENGTH_LONG).show();
    }
}
