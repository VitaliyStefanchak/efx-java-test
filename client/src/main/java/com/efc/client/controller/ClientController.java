package com.efc.client.controller;

import com.efc.client.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final static List<Price> result = new ArrayList<>();

    @PostMapping
    public void consumePrice(@RequestBody Price price) {
        result.add(price);
        log.info(price.toString());
    }

    @GetMapping
    public List<Price> getAllPrices() {
        return result;
    }
}
