package com.android.arc.model;

import com.android.arc.Remote.ArcService;

public class ApiUtils {
    private static final String BASE_API_URL = "https://arcbuild.azurewebsites.net/api/";

    public static ArcService getArcService() {
        return RetrofitClient.getClientLogin(BASE_API_URL).create(ArcService.class);
    }

}
