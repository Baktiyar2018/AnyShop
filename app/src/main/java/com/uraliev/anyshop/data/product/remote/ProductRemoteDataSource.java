package com.uraliev.anyshop.data.product.remote;

import com.uraliev.anyshop.data.product.ProductDataSource;
import com.uraliev.anyshop.model.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductRemoteDataSource implements ProductDataSource {

    public static ProductRemoteDataSource INSTANCE;

    //Region Static
    public static ProductDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ProductRemoteDataSource();
        }
        return INSTANCE;
    }
    //endregion

    private Retrofit getRetrofit(String baseUrl){
        return  new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private ProductNetworkClient mClient = getRetrofit(ProductRemoteConfig.BASE_URL).create(ProductNetworkClient.class);
    @Override
    public void getProducts(final ProductsCallback callback) {
        Call<ArrayList<Product>> call = mClient.getProducts();
        call.enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                if (response.isSuccessful()) {
                        if(response.body() != null){
                            callback.onSuccess(response.body());
                        }else
                        {
                            callback.onFail("Body id empty" + response.code());
                        }
                } else {
                    callback.onFail("Error code is "+ response.code());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getProduct(int id, ProductCallback callback) {

    }

    @Override
    public void addProducts(Product product) {

    }
}
