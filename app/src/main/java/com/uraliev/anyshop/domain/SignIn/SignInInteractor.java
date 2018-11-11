package com.uraliev.anyshop.domain.SignIn;

import com.uraliev.anyshop.data.user.UserDataSource;
import com.uraliev.anyshop.model.UserEntity;

public class SignInInteractor implements SignInUseCases {

    public SignInInteractor(UserDataSource userDataSource){
        this.mUserDataSource = userDataSource;
    }

    private UserDataSource mUserDataSource;

    @Override
    public void checkLogin(UserEntity loginEntity, SignInUseCases.UCCheckLoginCallback callback) {
        UserEntity currentUserData = mUserDataSource.getLoginData();

        if (currentUserData != null) {
            callback.onSuccess(
                    loginEntity.name.equals(currentUserData.name) &&
                            loginEntity.password.equals(currentUserData.password)
            );
        } else {
            callback.onFail("User data is empty!");
        }
    }
}
