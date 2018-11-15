package com.uraliev.anyshop.presentation.products;

import com.uraliev.core.BaseMVPContract;

public interface ListProductContract {
    interface View extends BaseMVPContract.View<Presenter>{
        void getListByCat();

    }

    interface Presenter extends BaseMVPContract.Presenter<View>{
        void onTabItem();
        void onPlusItem();
        void onMinusItem();
    }
}
