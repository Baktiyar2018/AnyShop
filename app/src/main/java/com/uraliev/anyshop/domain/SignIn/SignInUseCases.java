package com.uraliev.anyshop.domain.SignIn;

import com.uraliev.anyshop.core.callback.BaseCallback;
import com.uraliev.anyshop.model.LoginEntity;

public interface SignInUseCases {
    void checkLogin(LoginEntity loginEntity, UCCheckLoginCallback callback);

    abstract class UCCheckLoginCallback implements BaseCallback<Boolean> {
        @Override
        public void onFail(String message) {

        }
    }
}
