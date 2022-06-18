package com.efx.subscriber.service.priceadjuster;

import com.efx.subscriber.model.Price;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PriceAdjuster {

    private static final double DEFAULT_PERCENTAGE = 0.1;

    public void applyMarginToPrices(List<Price> prices) {
        prices.forEach(price -> {
            price.setAsk(price.getAsk().add(applyPercentageToValue(price.getAsk())));
            price.setBid(price.getBid().subtract(applyPercentageToValue(price.getBid())));
        });
    }

    private BigDecimal applyPercentageToValue(BigDecimal value) {
        return value.multiply(BigDecimal.valueOf(DEFAULT_PERCENTAGE / 100.0d));
    }
}
