package com.example.spring_typeconverter;

import com.example.spring_typeconverter.converter.IntegerToStringConverter;
import com.example.spring_typeconverter.converter.IpPortToStringConverter;
import com.example.spring_typeconverter.converter.StringToIntegerConverter;
import com.example.spring_typeconverter.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
    }
}
