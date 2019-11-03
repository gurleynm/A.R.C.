package com.android.arc.Pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.arc.R;
import com.android.arc.Remote.ArcService;
import com.android.arc.model.ApiUtils;
import com.android.arc.model.IOTService;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartPage extends Fragment implements View.OnClickListener{

    private ArcService mServiceRun;
    private Button carStart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.start_page, container, false);
        mServiceRun = ApiUtils.getArcService();
        carStart = rootView.findViewById(R.id.start_button);
        carStart.setOnClickListener(this);

        return rootView;
    }


    public void onClick(View view) {
        switch(view.getId()){
            case R.id.start_button:
                sendHttp();
                break;
        }
    }

    private void sendHttp(){
        mServiceRun.turnOn().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.print(response.code());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
