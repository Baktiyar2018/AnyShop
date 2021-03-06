package com.uraliev.core;


public interface BaseMVPContract {
    interface View<T extends Presenter> {
        void finishView();

        void attachPresenter(T presenter);
    }

    interface Presenter<T extends View> {
        void attachView(T view);

        void detachView();
    }
}
