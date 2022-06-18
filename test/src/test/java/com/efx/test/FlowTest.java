package com.efx.test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class FlowTest {

    public static final String PRODUCER_URL = "http://localhost:8080";
    public static final String CLIENT_URL = "http://localhost:8082";

    private final WebClient producerWebClient = WebClient.builder().baseUrl(PRODUCER_URL).build();
    private final WebClient clientWebClient = WebClient.builder().baseUrl(CLIENT_URL).build();

    private List<String> csvLinesList;

    @BeforeEach
    public void init() {
        csvLinesList = List.of(
                """
                        106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001
                        107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002
                        """,
                """
                        108, EUR/UA, 35.00, 36.000,01-06-2022 12:00:01:001
                        """,
                """
                        109, EUR/UA, 35.00,36.000,01-06-2022 12:00:01:001
                        110, USD/UA, 31.01,32.000,01-06-2022 12:00:01:001
                        111, EUR/GBR, 45.00,46.000,01-06-2022 12:00:01:001
                        """
        );
    }

    @Test
    public void testTheFlow() {
        csvLinesList.forEach(this::publishCsvLinesIntoQueue);

        waitUntilMessagesAreProceeded();

        Object[] results = getResultsFromClient();

        verifyResults(results);

        printResults(results);
    }

    private void publishCsvLinesIntoQueue(String csvLines) {
        producerWebClient.post()
                .uri("/api/producer")
                .body(BodyInserters.fromValue(csvLines))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @SneakyThrows
    private void waitUntilMessagesAreProceeded() {
        Thread.sleep(1000);
    }

    private Object[] getResultsFromClient() {
        return clientWebClient.get()
                .uri("/api/client")
                .retrieve()
                .bodyToMono(Object[].class)
                .block();
    }

    private void verifyResults(Object[] results) {
        assertNotNull(results);
        assertTrue(results.length > 0);
    }

    private void printResults(Object[] results) {
        log.info(Arrays.toString(results));
    }
}
