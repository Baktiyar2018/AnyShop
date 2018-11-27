package com.uraliev.anyshop.data.product.local;
import com.uraliev.anyshop.data.product.ProductDataSource;
import com.uraliev.anyshop.model.Product;
import com.uraliev.core.callback.BaseCallback;

import java.util.ArrayList;

public interface ProductLocalDataSource {
    void getProductsRealm(ProductDataSource.ProductsCallback callback);
    void getProductRealm(int id,ProductDataSource.ProductCallback callback);
    void addProduct(Product product);
    interface ProductsCallbackRealm extends BaseCallback<ArrayList<Product>> {}
    interface ProductCallbackRealm extends BaseCallback<Product>{}
}
