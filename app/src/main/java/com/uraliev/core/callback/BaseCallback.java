package com.uraliev.core.callback;


public interface BaseCallback<T> {
    void onSuccess(T result);

    void onFail(String message);
}
