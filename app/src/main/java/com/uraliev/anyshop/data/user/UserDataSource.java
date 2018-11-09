package com.uraliev.anyshop.data.user;


import com.uraliev.anyshop.core.callback.BaseCallback;
import com.uraliev.anyshop.model.LoginEntity;

// Created by askar on 11/2/18.
public interface UserDataSource {

    void checkLogin(LoginEntity loginData, DSCheckLoginCallback callback);

    LoginEntity getLoginData();

    abstract class DSCheckLoginCallback implements BaseCallback<Boolean> {
        @Override
        public void onFail(String message) {

        }
    }
}
