package com.uraliev.anyshop.domain.SignIn;

import com.uraliev.core.callback.BaseCallback;
import com.uraliev.anyshop.model.UserEntity;

public interface SignInUseCases {
    void checkLogin(UserEntity loginEntity, UCCheckLoginCallback callback);

    abstract class UCCheckLoginCallback implements BaseCallback<Boolean> {
        @Override
        public void onFail(String message) {

        }
    }
}
