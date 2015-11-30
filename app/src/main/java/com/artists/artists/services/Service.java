package com.artists.artists.services;

import com.artists.artists.MainApplication;
import com.artists.artists.R;
import com.artists.artists.model.DataRequest;

import retrofit.http.GET;
import rx.Observable;

public interface Service {
    String SERVICE_ENDPOINT =  MainApplication.getAppContext().getString(R.string.api_url);

    @GET("/data.json")
    Observable<DataRequest> getData();
}
