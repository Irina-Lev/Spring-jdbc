package com.product.star.homework;

import com.product.star.common.JdbcConfig;
import com.product.star.common.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@Import({JdbcConfig.class, PropertiesConfiguration.class})
public class ContactConfiguration {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ContactConfiguration(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Bean
    public ContactDao contactDao() {
        return new ContactDao(namedParameterJdbcTemplate);
    }
}
