package com.example.desarrollo.pruebalist;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ListViewAdapter adapter;
    GridViewAdapter gvAdapter;
    Button btnsalir, btnPerfil;
    String[] producto;
    ListView lista = null;
    GridView gvMain;

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
        int rotacion = getWindowManager().getDefaultDisplay().getRotation();
        if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {
                lista = (ListView) findViewById(R.id.listView1);
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

        } else {
            gvMain = (GridView)findViewById(R.id.gvMain);
            gvAdapter = new GridViewAdapter(this,producto,imagenes);
            gvMain.setAdapter(gvAdapter);

            gvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent in = new Intent(getApplicationContext(),DetalleActivity.class);
                    in.putExtra("posicion",i);
                    startActivity(in);
                }
            });
        }


        android.support.v7.widget.Toolbar myToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);



/*
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
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.perfil:
                Intent i = new Intent(getApplicationContext(),PerfilActivity.class);
                startActivity(i);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                finish();
                break;
            case R.id.menu:
                Intent j = new Intent(getApplicationContext(),GridviewActivity.class);
                startActivity(j);
                j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                finish();
                break;
            case R.id.listview:
                Intent k = new Intent(getApplicationContext(),ListviewActivity.class);
                startActivity(k);
                k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finish();
                break;
            case R.id.salir:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
