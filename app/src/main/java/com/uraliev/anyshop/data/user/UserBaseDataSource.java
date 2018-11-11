package com.uraliev.anyshop.data.user;


import com.uraliev.anyshop.model.UserEntity;

public abstract class UserBaseDataSource implements UserDataSource {
    @Override
    public void checkLogin(UserEntity loginData, DSCheckLoginCallback callback) {

    }

    @Override
    public UserEntity getLoginData() {
        return null;
    }
}
