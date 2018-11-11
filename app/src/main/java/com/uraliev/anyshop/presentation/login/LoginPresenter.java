package com.uraliev.anyshop.presentation.login;

import android.util.Log;


import com.uraliev.anyshop.domain.SignIn.SignInUseCases;
import com.uraliev.anyshop.model.UserEntity;


// Created by askar on 11/2/18.
public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View mView = null;
    private SignInUseCases mLoginUseCases;

    public LoginPresenter(SignInUseCases loginUseCases){
        mLoginUseCases = loginUseCases;
    }

    @Override
    public void attachView(LoginContract.View view) {
        mView = view;
        view.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onLoginClick(String name, String password) {
        if (mView != null && mLoginUseCases != null) {
            UserEntity loginEntity = new UserEntity(name, password, "");
            mLoginUseCases.checkLogin(loginEntity, new SignInUseCases.UCCheckLoginCallback(){
                @Override
                public void onSuccess(Boolean result) {
                    if (result){
                        mView.onLoginSuccess();
                        mView.finishView();
                    } else {
                        mView.onLoginFailure("Name or password is incorrect!");
                    }
                }

                @Override
                public void onFail(String message) {
                    Log.d("ololo", message);
                    super.onFail(message);
                }
            });
        }
    }
}
