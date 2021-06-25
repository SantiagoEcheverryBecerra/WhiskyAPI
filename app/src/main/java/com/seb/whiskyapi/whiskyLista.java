package com.seb.whiskyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.seb.whiskyapi.apimanager.RetrofitClient;
import com.seb.whiskyapi.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class whiskyLista extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listWhistky;
    List<Whisky> mywhisky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whisky);

        listWhistky = findViewById(R.id.listwhisky);
        getFromInternetWhisky();

        listWhistky.setOnItemClickListener(this);
    }

    private void getFromInternetWhisky() {
        Call<List<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWiskys();
        call.enqueue(new Callback<List<Whisky>>() {

            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                mywhisky = response.body();
                String message = "";
                AdapterWhisky adapter = new AdapterWhisky(whiskyLista.this, mywhisky);
                listWhistky.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Whisky>> call, Throwable t) {
                Toast.makeText(whiskyLista.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this, DetalleWhisky.class);
        in.putExtra("slug", mywhisky.get(position).getTvSlug());
        in.putExtra("url", mywhisky.get(position).getUrl());
        startActivity(in);
    }
}

