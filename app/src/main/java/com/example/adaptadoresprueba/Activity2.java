package com.example.adaptadoresprueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class Activity2 extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewDatos;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        imageView = findViewById(R.id.imageView);
        textViewDatos = findViewById(R.id.textViewDatos);
        linearLayout = findViewById(R.id.linearSnack);


        // el imageView y textViewDatos recibe el indicar que tiene que ser igual del activity del
        // que se manda que fue el logo y el precio
        imageView.setImageResource(getIntent().getIntExtra("logo", 0));
        textViewDatos.setText(getIntent().getExtras().getString("precio", "Taco: $15"));

        // random para variar el precio del taco y el snackbar para sacar el nuevo precio
        Random generador = new Random();
        final Snackbar snack = Snackbar.make(linearLayout, ("$" + generador.nextInt(24)), Snackbar.LENGTH_SHORT).setAction("NUEVO PRECIO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2.this, "Snack Action cliked", Toast.LENGTH_SHORT).show();
            }
        }).setActionTextColor(Color.GREEN);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snack.show();
            }
        });
    }
}
