package com.seb.whiskyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.seb.whiskyapi.apimanager.RetrofitClient;
import com.seb.whiskyapi.models.Destileria;
import com.seb.whiskyapi.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class destileriaLista extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listDestileria;
    List<Destileria> mydestileria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destileria);

        listDestileria = findViewById(R.id.listdestileria);
        getFromInternetDestileria();

        listDestileria.setOnItemClickListener(this);
    }
    private void getFromInternetDestileria() {
        Call<List<Destileria>> call = RetrofitClient.getInstance().getMyApi().getDestilerias();
        call.enqueue(new Callback<List<Destileria>>() {

            @Override
            public void onResponse(Call<List<Destileria>> call, Response<List<Destileria>> response) {
                mydestileria = response.body();
                String message = "";
                AdapterDestileria adapter = new AdapterDestileria(destileriaLista.this, mydestileria);
                listDestileria.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Destileria>> call, Throwable t) {
                Toast.makeText(destileriaLista.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in2 = new Intent(this, DetalleDestileria.class);
        in2.putExtra("slug", mydestileria.get(position).getTvSlugDesti());
        startActivity(in2);
    }
}