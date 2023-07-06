package com.example.comupnvargasdelgadofinal.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    public static Retrofit build() {
        return new Retrofit.Builder()
                .baseUrl("https://64a2d060b45881cc0ae5bdd6.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
