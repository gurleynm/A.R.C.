package com.android.arc.Pages;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.arc.R;
import com.android.arc.Remote.ArcService;
import com.android.arc.model.ApiUtils;
import com.android.arc.model.Device;
import com.android.arc.model.Token;
import com.android.arc.model.User;

import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends Fragment implements View.OnClickListener{

    private Button registerBtn;
    private ArcService mService;
    private EditText Username;
    private EditText Password;
    private EditText ConfirmPassword;
    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.register_page, container, false);
        registerBtn = rootView.findViewById(R.id.register_button);
        Username = rootView.findViewById(R.id.username);
        Password = rootView.findViewById(R.id.password);
        ConfirmPassword = rootView.findViewById(R.id.confirm_password);
        registerBtn.setOnClickListener(this);
        mService = ApiUtils.getArcService();

        return rootView;
    }

    @Override
    public void onClick(View view) {
        if(!properLength())
            return;
        user = new User();
        user.setUserID(UUID.randomUUID().toString());
        user.setUsername(Username.getText().toString());
        user.setPassword(Password.getText().toString());
        mService.addUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                createToken();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private boolean properLength(){
        return Username.getText() != null && Username.getText().length() > 2 &&
                Password.getText() != null && Password.getText().length() > 4 &&
                ConfirmPassword.getText() != null && ConfirmPassword.getText().length() > 4;
    }

    private void createToken(){
        mService.getAndAddToken(user).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                enter();
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {

            }
        });
    }

    private void enter(){
        StartPage startPage = new StartPage();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, startPage).addToBackStack(null).commit();
    }
}
