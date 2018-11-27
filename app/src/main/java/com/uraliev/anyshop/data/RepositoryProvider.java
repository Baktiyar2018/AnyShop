package com.uraliev.anyshop.data;


import com.uraliev.anyshop.data.product.ProductDataSource;
import com.uraliev.anyshop.data.product.ProductRepository;
import com.uraliev.anyshop.data.product.remote.ProductRemoteDataSource;
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

    public static ProductDataSource getProductRepository(){
        return ProductRepository.getInstance(
                null,
                ProductRemoteDataSource.getInstance()
        );
    }


}
