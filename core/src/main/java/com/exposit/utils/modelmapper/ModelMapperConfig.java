package com.exposit.utils.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Class is responsible for configuration of mapping objects.
 * Mapping is provided by ModelMapper library.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
