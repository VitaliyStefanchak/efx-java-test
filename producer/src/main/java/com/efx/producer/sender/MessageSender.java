package com.efx.producer.sender;

public interface MessageSender<T> {

    void sendMessage(T message);
}
