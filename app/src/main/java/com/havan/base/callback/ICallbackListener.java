package com.havan.base.callback;

/**
 * Created by H.T. on 01/12/17.
 */

public interface ICallbackListener<T> {
    void onSuccess(T data);

    void onFailure(Throwable t);
}
