package com.uraliev.anyshop.presentation.categories;

import com.uraliev.core.BaseMVPContract;

public interface CategoryContract {
    interface View extends BaseMVPContract.View<Presenter>{
        void getCategory();
    }
    interface Presenter extends BaseMVPContract.Presenter<View>{
       void onItemClick();
    }
}
