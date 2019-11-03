package com.android.arc.Pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.arc.R;
import com.android.arc.Remote.ArcService;
import com.android.arc.model.ApiUtils;
import com.android.arc.model.Device;
import com.android.arc.model.Token;
import com.android.arc.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPage extends Fragment implements View.OnClickListener{

    private Button login;
    private ArcService mService;
    private EditText Username;
    private EditText Password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.login_page, container, false);
        login = rootView.findViewById(R.id.login_button);
        Username = rootView.findViewById(R.id.username);
        Password = rootView.findViewById(R.id.password);
        login.setOnClickListener(this);
        mService = ApiUtils.getArcService();

        return rootView;
    }

    @Override
    public void onClick(View view) {
        final String user = Username.getText().toString();

        mService.getUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                try {
                    if (validate(response.body().getPassword()))
                        enter();
                    else
                        Username.setText("Wrong Password");
                }catch(Exception e){
                    Username.setText("Incorrect credentials");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private boolean validate(String passW){
        return passW.equals(Password.getText().toString());
    }

    private void enter(){
        StartPage startPage = new StartPage();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, startPage).addToBackStack(null).commit();
    }
}
