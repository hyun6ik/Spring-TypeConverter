package com.example.spring_typeconverter.converter;

import com.example.spring_typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    public void conversionService() throws Exception {
        //given
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        //when
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);

        //then
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        assertThat(conversionService.convert(ipPort, String.class)).isEqualTo("127.0.0.1:8080");

    }
}
