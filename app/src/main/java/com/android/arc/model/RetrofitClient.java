package com.android.arc.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClient {

    private static Retrofit retrofitLogin = null;
    private static Retrofit retrofitStart = null;

    public static Retrofit getClientLogin(String baseUrl) {
        retrofitLogin = null;

        if (baseUrl != null) {
            retrofitLogin = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitLogin;
    }

    public static Retrofit getClientStart(String baseUrl) {
        retrofitStart = null;

        if (baseUrl != null) {
            retrofitStart = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitStart;
    }
}
