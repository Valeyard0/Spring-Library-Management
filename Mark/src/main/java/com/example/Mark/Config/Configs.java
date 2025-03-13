package com.example.Mark.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configs {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
