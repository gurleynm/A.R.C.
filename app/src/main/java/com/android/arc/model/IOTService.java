package com.android.arc.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IOTService {

    @Headers({"Content-Type: application/json",
            "Authorization: SharedAccessSignature sr=ARC.azure-devices.net&sig=EA2k%2FRZr%2BhZsnn%2BnWlp3LIZJjtOxbQY6FG4917ulIco%3D&skn=iothubowner&se=1572885367"
    })
    @POST("{deviceId}/methods?api-version=2018-06-30")
    Call<ResponseBody> sendData(@Path("deviceId") String deviceId, @Body String data);
}
