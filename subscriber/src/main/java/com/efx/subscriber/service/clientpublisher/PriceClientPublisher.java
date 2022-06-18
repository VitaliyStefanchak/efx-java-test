package com.efx.subscriber.service.clientpublisher;

import com.efx.subscriber.model.Price;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class PriceClientPublisher implements ClientPublisher<Price> {

    @Value(value = "${client.address}")
    private String clientAddress;

    @Override
    public void sentToClient(List<Price> prices) {
        prices.forEach(this::sendPriceToClient);
    }

    private void sendPriceToClient(Price price) {
        WebClient client = WebClient.builder()
                .baseUrl(clientAddress)
                .build();

        client.post()
                .uri(API_CLIENT_PATH)
                .body(BodyInserters.fromValue(price))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
