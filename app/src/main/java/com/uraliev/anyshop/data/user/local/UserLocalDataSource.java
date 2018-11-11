package com.uraliev.anyshop.data.user.local;


import com.uraliev.anyshop.data.user.UserBaseDataSource;
import com.uraliev.anyshop.data.user.UserDataSource;
import com.uraliev.anyshop.model.UserEntity;

public class UserLocalDataSource extends UserBaseDataSource {
    private String USERNAME = "Tameki";
    private String PASSWORD = "123456789";

    //region Static

    private static UserLocalDataSource INSTANCE;

    public static UserDataSource getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new UserLocalDataSource();
        }

        return INSTANCE;
    }

    //endregion


    //region Contract

    @Override
    public void checkLogin(UserEntity loginData, DSCheckLoginCallback callback) {
        callback.onSuccess(
                USERNAME.equals(loginData.name) &&
                        PASSWORD.equals(loginData.password)
        );
    }

    @Override
    public UserEntity getLoginData() {
        return new UserEntity(USERNAME, PASSWORD, "");
    }

    //endregion
}
