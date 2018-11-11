package com.uraliev.anyshop.presentation.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.uraliev.anyshop.domain.UseCaseProvider;


public class LoginActivity extends AppCompatActivity {

    private LoginContract.Presenter mPresenter = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment fragment = LoginFragment.getInstance();

        mPresenter = new LoginPresenter(
                UseCaseProvider.getLoginUseCase()
        );

        mPresenter.attachView(fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();
    }
}
