package com.example.desarrollo.pruebalist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by desarrollo on 09-15-18.
 */

public class GridViewAdapter extends BaseAdapter{
private Context context;
    String[] productos;
    int[] imagenes;
    LayoutInflater inflater;
    TextView tvnombre;
    ImageView imgridView;

    public GridViewAdapter(Context context, String[] productos, int[] imagenes) {
        this.context = context;
        this.productos = productos;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return productos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item;
        if (view == null){
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            item = new View(context);
            item= inflater.inflate(R.layout.gridview,null);
        }else{
            item=(View)view;
        }
        tvnombre = item.findViewById(R.id.tvGridView);
        imgridView = item.findViewById(R.id.imGridView);
        tvnombre.setText(productos[i]);
        imgridView.setImageResource(imagenes[i]);
        return item;
    }

}
