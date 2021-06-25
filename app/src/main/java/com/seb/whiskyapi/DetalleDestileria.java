package com.seb.whiskyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;
import com.seb.whiskyapi.apimanager.RetrofitClient;
import com.seb.whiskyapi.models.Destileria;
import com.seb.whiskyapi.models.Whisky;
import com.seb.whiskyapi.models.destileriaDetalles;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleDestileria extends AppCompatActivity {

    private String slug;
    List<destileriaDetalles>destilerias;

    TextView Fecha;
    TextView Pujaganadoramax;
    TextView Pujaganadoraminima;
    TextView Pujaganadoramedia;
    TextView Volumencomercio;
    TextView Conteolotes;
    TextView Nombre;
    TextView Codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_destileria);

        Bundle in2 = getIntent().getExtras();
        slug = in2.getString("slug");
        Toast.makeText(this, slug, Toast.LENGTH_LONG).show();

        Fecha = findViewById(R.id.fecha);
        Pujaganadoramax = findViewById(R.id.pujaganadoramax);
        Pujaganadoraminima = findViewById(R.id.pujaganadoraminima);
        Pujaganadoramedia = findViewById(R.id.pujaganadoramedia);
        Volumencomercio = findViewById(R.id.volumencomercio);
        Conteolotes = findViewById(R.id.conteolotes);
        Nombre = findViewById(R.id.nombre);
        Codigo = findViewById(R.id.codigo);

        getDestileriaBySlug(slug);

    }


    private void getDestileriaBySlug(String slug){
        Call<List<destileriaDetalles>> call = RetrofitClient.getInstance().getMyApi().getDestileria(slug);
        call.enqueue(new Callback<List<destileriaDetalles>>() {
            @Override
            public void onResponse(Call<List<destileriaDetalles>> call, Response<List<destileriaDetalles>> response) {
                destilerias = response.body();

                //Log.d("TAG", "URL: " + destilerias.get(0).getTvNameDesti());
                //Log.d("TAG", "URL: " + destilerias.get(0).getTvSlugDesti());
                //Log.d("TAG", "URL: " + destilerias.get(0).getTvPaisDesti());

                Fecha.setText(destilerias.get(0).getFecha());
                Pujaganadoramax.setText(destilerias.get(0).getPujaganadoramax());
                Pujaganadoraminima.setText(destilerias.get(0).getPujaganadoraminima());
                Pujaganadoramedia.setText(destilerias.get(0).getPujaganadoramedia());
                Volumencomercio.setText(destilerias.get(0).getVolumencomercio());
                Conteolotes.setText(destilerias.get(0).getConteolotes());
                Nombre.setText(destilerias.get(0).getNombre());
                Codigo.setText(destilerias.get(0).getCodigo());

            }

            @Override
            public void onFailure(Call<List<destileriaDetalles>> call, Throwable t) {
                Toast.makeText(DetalleDestileria.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}