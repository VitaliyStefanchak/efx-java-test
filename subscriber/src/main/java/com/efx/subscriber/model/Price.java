package com.efx.subscriber.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "name", "bid", "ask", "timestamp"})
public class Price {

    Long id;
    String name;
    BigDecimal bid;
    BigDecimal ask;
    String timestamp;
}
