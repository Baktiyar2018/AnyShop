package com.uraliev.anyshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.uraliev.anyshop.data.product.ProductDataSource;
import com.uraliev.anyshop.data.product.ProductRepository;
import com.uraliev.anyshop.model.Product;
import com.uraliev.anyshop.presentation.main.MainFragment;

import java.util.List;


public class MainActivity extends AppCompatActivity {

     ProductRepository mProductRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }


        //mProductRepository = new ProductRepository();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mProductRepository.addProducts(
                new Product(0,"Sony","product of Sony company",null,null)
        );
            mProductRepository.getProducts(new ProductDataSource.ProductsCallback() {
                @Override
                public void onSuccess(List<Product> result) {
                    for(Product product : result){
                        Log.d("ololo",product.toString());
                    }
                }

                @Override
                public void onFail(String message) {

                }
            });

    }
}
