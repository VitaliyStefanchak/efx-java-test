package com.efx.subscriber.service.clientpublisher;

import java.util.List;

public interface ClientPublisher<T> {

    String API_CLIENT_PATH = "/api/client";

    void sentToClient(List<T> payload);
}
