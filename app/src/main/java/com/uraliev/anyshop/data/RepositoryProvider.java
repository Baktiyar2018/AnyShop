package com.uraliev.anyshop.data;


import com.uraliev.anyshop.data.user.UserDataSource;
import com.uraliev.anyshop.data.user.UserRepository;
import com.uraliev.anyshop.data.user.local.UserLocalDataSource;
import com.uraliev.anyshop.data.user.remote.UserRemoteDataSource;

public class RepositoryProvider {
    public static UserDataSource getUserRepository(){
        return UserRepository.getInstance(
                UserLocalDataSource.getInstance(),
                UserRemoteDataSource.getInstance()
        );
    }


}
