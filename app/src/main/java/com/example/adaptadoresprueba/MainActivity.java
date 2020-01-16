package com.example.adaptadoresprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Array de las imagenes cargadas por nombre de imagen
    private int[] logoId = new int[]{R.drawable.asada,
            R.drawable.alpastor, R.drawable.pollo, R.drawable.aguja,
            R.drawable.tripa, R.drawable.campechano};

    //Arrays de los nombres de los tacos y precios
    private String[] listitas = {"Asada", "AlPastor", "Pollo", "Aguja", "Tripa", "Campechano"};
    private String[] precios = {"Taco de Asada: $15", "Taco de Alpastor: $22", "Taco de Pollo: $21",
            "Taco de Aguja: $14", "Taco de Tripa: $12", "Taco de Campechano: $17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //se crea la lista y se agrega el contexto al list View
        final ListView lista = new ListView(this);
        setContentView(lista);
        // se crea el array adapter y se agrega el adapter a la lista
        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.mi_renglon,
                R.id.textView, listitas);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // se crea intent para enviar al activity2
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra("logo", logoId[position]);
                intent.putExtra("precio", precios[position]);
                startActivity(intent);
                // El snakbar es para que salga el precio de los tacos en random
                // pero como se pasa a otro activity2 no se pone y se manda el precio con el intent.putExtra("precio",precios[position]);
//                Random generador = new Random();
//                Snackbar.make(parent, ("$" + generador.nextInt(200)), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}