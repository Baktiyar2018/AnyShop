package com.uraliev.anyshop.presentation.login;


import com.uraliev.anyshop.core.BaseMVPContract;

public interface LoginContract {
    interface View extends BaseMVPContract.View<Presenter> {
        void onLoginSuccess();

        void onLoginFailure(String message);
    }

    interface Presenter extends BaseMVPContract.Presenter<View>{
        void onLoginClick(String name, String password);
    }
}
