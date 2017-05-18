package com.example.bd.mannequincollection;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Modelos extends AppCompatActivity {

    TextView lista, agregar, editar, buscar;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelos);

        agregar = (TextView) findViewById(R.id.agregarModelo);
        lista = (TextView) findViewById(R.id.listaModelos);
        editar = (TextView) findViewById(R.id.editarModelo);
        buscar = (TextView) findViewById(R.id.buscarModelo);
        reg = (Button) findViewById(R.id.btVolver);
    }

    public void regresar(View v){
        Intent intent = new Intent(Modelos.this, MainActivity.class);
        startActivity(intent);
    }

    public void agregaModelo(View  v){
        Intent intent = new Intent(Modelos.this, AgregaModelo.class);
        startActivity(intent);
    }

    public void listaModelos(View v) {
        Intent intent = new Intent(Modelos.this, ListaDeModelos.class);
        startActivity(intent);
    }

    public void editarModelo(View v){
        Intent intent = new Intent(Modelos.this, EditarModelo.class);
        startActivity(intent);
    }

    public void buscarModelo(View v){
        Intent intent = new Intent(Modelos.this, BuscaModelo.class);
        startActivity(intent);
    }
}
