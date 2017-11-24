package com.example.rxjava2.callback;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 26050 on 2017/11/24.
 */

public interface GetRequest_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20register")
    Observable<Translation1> getCall();

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20login")
    Observable<Translation2> getCall_2();
}
