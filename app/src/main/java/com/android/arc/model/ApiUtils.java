package com.android.arc.model;

import com.android.arc.Remote.ArcService;

public class ApiUtils {

    private static final String BASE_URL = "https://ARC.azure-devices.net/twins/";
    private static final String BASE_API_URL = "https://arcbuild.azurewebsites.net/api/";

    public static IOTService getIOTService() {
        return RetrofitClient.getClient(BASE_URL).create(IOTService.class);
    }

    public static ArcService getArcService() {
        return RetrofitClient.getClient(BASE_API_URL).create(ArcService.class);
    }

}
