package com.example.spring_typeconverter.converter;


import com.example.spring_typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    public void stringToInteger() throws Exception {
        //given
        StringToIntegerConverter converter = new StringToIntegerConverter();
        //when
        Integer result = converter.convert("10");
        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void integerToString() throws Exception {
        //given
        IntegerToStringConverter converter = new IntegerToStringConverter();
        //when
        String result = converter.convert(10);
        //then
        assertThat(result).isEqualTo("10");
    }

    @Test
    public void ipPortToString() throws Exception {
        //given
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = IpPort.of("127.0.0.1", 8080);
        //when
        String ipAddress = converter.convert(source);
        //then
        assertThat(ipAddress).isEqualTo("127.0.0.1:8080");

    }
    
    @Test
    public void stringToIpPort() throws Exception {
        //given
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String ipAddress = "127.0.0.1:8080";
        //when
        IpPort ipPort = converter.convert(ipAddress);
        //then
        assertThat(ipPort.getIp()).isEqualTo("127.0.0.1");
        assertThat(ipPort.getPort()).isEqualTo(8080);
        
    }
}
