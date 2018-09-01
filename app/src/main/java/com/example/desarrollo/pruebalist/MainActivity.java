package com.example.desarrollo.pruebalist;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListViewAdapter adapter;
    Button btnsalir, btnPerfil;
    String[] producto;


    int[] imagenes = {
            R.drawable.iphone,
            R.drawable.ipad,
            R.drawable.celular,
            R.drawable.laptop,
            R.drawable.desktop,
            R.drawable.chomecast,
            R.drawable.dvd,
            R.drawable.software,
            R.drawable.hardware,
            R.drawable.monitor,
            R.drawable.mouse,
            R.drawable.teclado,
            R.drawable.bluetooh,
            R.drawable.disco,
            R.drawable.ddr
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        producto = getResources().getStringArray(R.array.producto);
        btnPerfil = (Button)findViewById(R.id.btnPefil);
        btnsalir= (Button)findViewById(R.id.btnSalir);
        final ListView lista = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(this, producto, imagenes);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Intent d = new Intent(getApplicationContext(), DetalleActivity.class);
                //Toast.makeText(getApplicationContext(),"posicion"+i,Toast.LENGTH_SHORT).show();
                d.putExtra("posicion",i);
                startActivity(d);
                finish();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
               Intent d = new Intent(getApplicationContext(), DetalleActivity.class);
               startActivity(d);
               return true;
            }
        });

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                finish();
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PerfilActivity.class);
                startActivity(i);
                finish();

            }
        });

    }

}
