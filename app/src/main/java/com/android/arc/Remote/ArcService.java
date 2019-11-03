package com.android.arc.Remote;

import com.android.arc.model.Device;
import com.android.arc.model.Token;
import com.android.arc.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ArcService {
    @GET("user/{UserID}")
    Call<User> getUser(@Path("UserID") String UserID);

    @GET("device")
    Call<ResponseBody> turnOn();

    @Headers("Content-Type: application/json")
    @POST("user")
    Call<User> addUser(@Body User user);

    @Headers("Content-Type: application/json")
    @GET("token")
    Call<Device> getDevice();

    @Headers("Content-Type: application/json")
    @POST("token")
    Call<Token> getAndAddToken(@Body User user);

}
