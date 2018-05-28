package com.havan.base.callback;

/**
 * Created by H.T. on 01/12/17.
 */

public interface IFirebaseCallbackListener<T> {

    void childAdded(T object);

    void childChanged(T object);

    void childRemoved(T object);

    void onFailure(Throwable t);
}
