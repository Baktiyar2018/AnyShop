package com.uraliev.anyshop.domain;


import com.uraliev.anyshop.data.RepositoryProvider;
import com.uraliev.anyshop.domain.SignIn.LoginUseCases;

public class UseCaseProvider {
    public static LoginUseCases getLoginUseCase(){
        return new LoginInteractor(
                RepositoryProvider.getUserRepository()
        );
    }
}
