package com.uraliev.anyshop.data.user.remote;


import com.uraliev.anyshop.data.user.UserBaseDataSource;
import com.uraliev.anyshop.data.user.UserDataSource;

public class UserRemoteDataSource extends UserBaseDataSource {

    //region Static

    private static UserRemoteDataSource INSTANCE;

    public static UserDataSource getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteDataSource();
        }

        return INSTANCE;
    }

    //endregion
}
