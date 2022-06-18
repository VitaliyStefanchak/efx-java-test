package com.efx.subscriber.service.priceparser;

import com.efx.subscriber.model.Price;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvLinesPriceParser implements PriceParser<String> {

    private final CsvMapper csvMapper;
    private final CsvSchema csvSchema;

    @Override

    @SneakyThrows
    public List<Price> toPrices(String csvLines) {
        MappingIterator<Price> priceMappingIterator = csvMapper
                .readerWithTypedSchemaFor(Price.class)
                .with(csvSchema)
                .readValues(csvLines);

        return priceMappingIterator.readAll();
    }
}