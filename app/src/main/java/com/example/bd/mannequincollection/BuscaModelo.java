package com.example.bd.mannequincollection;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BuscaModelo extends AppCompatActivity {

    android.app.FragmentManager fm;
    FragmentTransaction ft;
    Button busqueda, reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_modelo);
        busqueda = (Button) findViewById(R.id.btBuscaModelo);
        reg = (Button) findViewById(R.id.btVolver);
//        fm = getFragmentManager();
//        ft = fm.beginTransaction();
//        Fragment frag = new FragmentoBusqueda();
//        ft.add(R.id.fragmentoBuscar, frag);
//        ft.commit();
    }

    public void regresar(View v){
        Intent intent = new Intent(BuscaModelo.this, Modelos.class);
        startActivity(intent);
    }



}
