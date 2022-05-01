package com.example.cartelera2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
private ImageButton btnPeliUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnPeliUno= findViewById(R.id.btnPeliUno);

        btnPeliUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegar = new Intent(MainActivity.this, peli_uno.class);
                startActivity(navegar);
            }
        });
    }
}



