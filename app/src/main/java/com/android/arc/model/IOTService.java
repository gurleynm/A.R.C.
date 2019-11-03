package com.android.arc.model;


import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IOTService {

    @Headers({"Content-type: text/plain; charset=utf-8",
            "Authorization: SharedAccessSignature sr=ARC.azure-devices.net&sig=EA2k%2FRZr%2BhZsnn%2BnWlp3LIZJjtOxbQY6FG4917ulIco%3D&skn=iothubowner&se=1572885367"
    })
    @POST("/{deviceId}/methods?api-version=2018-06-30")
    Call<JsonObject> sendData(@Path("deviceId") String deviceId, @Body String data);
}
