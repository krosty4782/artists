package com.artists.artists.services;

import com.artists.artists.model.DataRequest;


import rx.Observable;

public class RequestManager {

    private static Service service = ServiceFactory.createRetrofitService(Service.class, Service.SERVICE_ENDPOINT);

    public static Observable<DataRequest> getData() {
        return service.getData();
    }
}
