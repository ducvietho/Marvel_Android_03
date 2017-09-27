package com.framgia.moviedb.data.source.remote.api.service;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ducviet on 22/09/2017.
 */

public class ServiceClient {
    public ServiceClient() {
    }

    static <T> T createService(String endPoint, Class<T> serviceClass) {
        return createService(endPoint, serviceClass, null);
    }

    static <T> T createService(String endPoint, Class<T> serviceClass, @NonNull Gson gson) {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}