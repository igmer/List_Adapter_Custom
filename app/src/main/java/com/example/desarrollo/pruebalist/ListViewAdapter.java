package com.example.desarrollo.pruebalist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] productos;
    int[] imagenes;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] productos, int[] imagenes) {
        this.context = context;
        this.productos = productos;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return productos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitle;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row, parent, false);

        // Locate the TextViews in listview_item.xml
        txtTitle = (TextView) itemView.findViewById(R.id.list_row_title);
        imgImg = (ImageView) itemView.findViewById(R.id.list_row_image);

        // Capture position and set to the TextViews
        txtTitle.setText(productos[position]);
        imgImg.setImageResource(imagenes[position]);
        return itemView;
    }
    public static String detalle(Context context, String[] productos, int pos){
        String detallep="";
        for (int i = 0; i <productos.length ; i++) {
             detallep = productos[pos];
        }
        return  detallep;

    }
}