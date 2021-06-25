package com.seb.whiskyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.seb.whiskyapi.apimanager.RetrofitClient;
import com.seb.whiskyapi.models.Whisky;
import com.seb.whiskyapi.models.whiskyDetalle;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleWhisky extends AppCompatActivity implements View.OnClickListener {

    private String slug;
    private String url;
    private Button URL;
    List<whiskyDetalle>whisky;

    TextView Fecha;
    TextView pujaMaxima;
    TextView pujaMinima;
    TextView cantidadMaxima;
    TextView CantiadaSusbastas;
    TextView nombre;
    TextView codigo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_wisky);

        Bundle in = getIntent().getExtras();
        slug = in.getString("slug");
        url = in.getString("url");
        //Toast.makeText(this, slug, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, url, Toast.LENGTH_LONG).show();



        Fecha = findViewById(R.id.fecha);
        pujaMaxima = findViewById(R.id.PujaMaxima);
        pujaMinima = findViewById(R.id.PujaMinima);
        cantidadMaxima = findViewById(R.id.CantidadMaxima);
        CantiadaSusbastas = findViewById(R.id.cantiadaSusbastas);
        nombre = findViewById(R.id.Nombre);
        codigo = findViewById(R.id.Codigo);
        URL = findViewById(R.id.btnURL);

        URL.setOnClickListener(this);

        getWhiskyBySlug(slug);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void getWhiskyBySlug(String slug){
        Call<List<whiskyDetalle>> call = RetrofitClient.getInstance().getMyApi().getWisky(slug);
        call.enqueue(new Callback<List<whiskyDetalle>>() {
            @Override
            public void onResponse(Call<List<whiskyDetalle>> call, Response<List<whiskyDetalle>> response) {
                whisky = response.body();

                //Log.d("TAG", "URL: " + whisky.get(0).getFecha());
                //Log.d("TAG", "URL: " + whisky.get(0).getTvSlug());
                //Log.d("TAG", "URL: " + whisky.get(0).getTvMoneda());

                Fecha.setText(whisky.get(0).getFecha());
                pujaMaxima.setText(whisky.get(0).getPujaMaxima());
                pujaMinima.setText(whisky.get(0).getPujaMinima());
                cantidadMaxima.setText(whisky.get(0).getCantidadMaxima());
                CantiadaSusbastas.setText(whisky.get(0).getCantiadaSusbastas());
                nombre.setText(whisky.get(0).getNombre());
                codigo.setText(whisky.get(0).getCodigo());

            }

            @Override
            public void onFailure(Call<List<whiskyDetalle>> call, Throwable t) {
                Toast.makeText(DetalleWhisky.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}