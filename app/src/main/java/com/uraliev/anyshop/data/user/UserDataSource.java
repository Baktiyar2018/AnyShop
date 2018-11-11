package com.uraliev.anyshop.data.user;


import com.uraliev.core.callback.BaseCallback;
import com.uraliev.anyshop.model.UserEntity;

// Created by askar on 11/2/18.
public interface UserDataSource {

    void checkLogin(UserEntity loginData, DSCheckLoginCallback callback);

    UserEntity getLoginData();

    abstract class DSCheckLoginCallback implements BaseCallback<Boolean> {
        @Override
        public void onFail(String message) {

        }
    }
}
