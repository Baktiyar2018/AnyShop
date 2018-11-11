package com.uraliev.anyshop.domain;


import com.uraliev.anyshop.data.RepositoryProvider;
import com.uraliev.anyshop.domain.SignIn.SignInInteractor;
import com.uraliev.anyshop.domain.SignIn.SignInUseCases;

public class UseCaseProvider {
    public static SignInUseCases getLoginUseCase(){
        return new SignInInteractor(
                RepositoryProvider.getUserRepository()
        );
    }
}
