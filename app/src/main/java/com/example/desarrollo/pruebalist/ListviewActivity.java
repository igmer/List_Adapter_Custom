package com.example.desarrollo.pruebalist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        android.support.v7.widget.Toolbar myToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);
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
                finish();
                break;
            case R.id.menu:
                Intent j = new Intent(getApplicationContext(),GridviewActivity.class);
                startActivity(j);
                finish();
                break;
            case R.id.listview:
                Intent k = new Intent(getApplicationContext(),ListviewActivity.class);
                startActivity(k);
                finish();
                break;
            case R.id.salir:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}


