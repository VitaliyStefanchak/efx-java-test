package com.efc.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Price {

    Long id;
    String name;
    BigDecimal bid;
    BigDecimal ask;
    String timestamp;
}
