package com.example.souad_cisse_exam_m1_iibdcc_23.souad_cisse_network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class IPRetrofitClient {
    private static IPRetrofitClient instance = null;
    private IPApi myApi;

    private IPRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IPApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(IPApi.class);
    }

    public static synchronized IPRetrofitClient getInstance() {
        if (instance == null) {
            instance = new IPRetrofitClient();
        }
        return instance;
    }

    public IPApi geIPApi() {
        return myApi;
    }
}
