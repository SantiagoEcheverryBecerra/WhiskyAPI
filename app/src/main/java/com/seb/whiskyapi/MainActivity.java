package com.seb.whiskyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgWisky;
    private ImageButton imgDestileria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWisky = findViewById(R.id.img1);
        imgDestileria = findViewById(R.id.img2);
        imgWisky.setOnClickListener(this);
        imgDestileria.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img1){
            Intent in = new Intent(this, destileriaLista.class);
            startActivity(in);
        }

        if (v.getId() == R.id.img2){
            Intent Myintent = new Intent(this, whiskyLista.class);
            startActivity(Myintent);
        }
    }
}