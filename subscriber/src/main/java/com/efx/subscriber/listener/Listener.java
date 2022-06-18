package com.efx.subscriber.listener;

public interface Listener<T> {

    void listen(T message);
}
