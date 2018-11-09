package com.uraliev.anyshop.data.user;


import com.uraliev.anyshop.model.LoginEntity;

public abstract class UserBaseDataSource implements UserDataSource {
    @Override
    public void checkLogin(LoginEntity loginData, DSCheckLoginCallback callback) {

    }

    @Override
    public LoginEntity getLoginData() {
        return null;
    }
}
