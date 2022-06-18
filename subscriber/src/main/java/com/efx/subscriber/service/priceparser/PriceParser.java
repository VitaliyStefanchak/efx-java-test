package com.efx.subscriber.service.priceparser;

import com.efx.subscriber.model.Price;

import java.util.List;

public interface PriceParser<T> {

    List<Price> toPrices(T object);
}
