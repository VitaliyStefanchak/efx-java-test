package com.efx.subscriber.listener;

import com.efx.subscriber.model.Price;
import com.efx.subscriber.service.clientpublisher.PriceClientPublisher;
import com.efx.subscriber.service.priceadjuster.PriceAdjuster;
import com.efx.subscriber.service.priceparser.CsvLinesPriceParser;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.efx.subscriber.config.KafkaConsumerConfig.DEFAULT_GROUP_ID;

@Component
@RequiredArgsConstructor
public class CsvLinesPriceListener implements PriceListener<String> {

    private final CsvLinesPriceParser priceParser;
    private final PriceAdjuster priceAdjuster;
    private final PriceClientPublisher priceClientPublisher;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = DEFAULT_GROUP_ID)
    public void listen(String csvLinesMessage) {
        List<Price> prices = priceParser.toPrices(csvLinesMessage);
        priceAdjuster.applyMarginToPrices(prices);
        priceClientPublisher.sentToClient(prices);
    }
}
