package com.efx.subscriber.config;

import com.efx.subscriber.model.Price;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean CsvMapper csvMapper(){
        return new CsvMapper();
    }

    @Bean
    public CsvSchema csvSchema() {
        return csvMapper()
                .typedSchemaFor(Price.class)
                .withColumnSeparator(',')
                .withLineSeparator("\n")
                .withComments();
    }
}
