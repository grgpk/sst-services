package com.sst.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {

    @Bean
    ModelMapper modelMapper() {
        return  new ModelMapper();
    }

}
