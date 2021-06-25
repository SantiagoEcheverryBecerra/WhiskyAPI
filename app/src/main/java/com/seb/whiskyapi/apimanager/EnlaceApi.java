package com.seb.whiskyapi.apimanager;

import com.seb.whiskyapi.models.Destileria;
import com.seb.whiskyapi.models.Whisky;
import com.seb.whiskyapi.models.destileriaDetalles;
import com.seb.whiskyapi.models.whiskyDetalle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EnlaceApi {
    String BASE_URL="https://whiskyhunter.net/api/";
    //END_POINTS

    @GET("auctions_info")
    Call<List<Whisky>> getWiskys();

    @GET("distilleries_info/")
    Call<List<Destileria>> getDestilerias();

    @GET("auction_data/{slug}/")
    Call<List<whiskyDetalle>> getWisky(@Path("slug") String slug);

    @GET("distillery_data/{slug}/")
    Call<List<destileriaDetalles>> getDestileria(@Path("slug") String slug);

}
