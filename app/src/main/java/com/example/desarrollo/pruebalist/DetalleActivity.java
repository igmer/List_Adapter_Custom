package com.example.desarrollo.pruebalist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
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
    TextView tvDetalle;
    ImageView imDetalle,imsalirdet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        tvDetalle = (TextView)findViewById(R.id.tvDetalle);
        imDetalle =(ImageView)findViewById(R.id.imDetalle);
        imsalirdet =(ImageView)findViewById(R.id.imsalirdet);
        Intent i = getIntent();
        int pos = i.getIntExtra("posicion", 0);
        String[] detalleArray = getResources().getStringArray(R.array.detalle);
        String  detalle = ListViewAdapter.detalle(getApplicationContext(),detalleArray,pos);
        imDetalle.setImageResource(imagenes[pos]);
        tvDetalle.setText(detalle);
        imsalirdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
