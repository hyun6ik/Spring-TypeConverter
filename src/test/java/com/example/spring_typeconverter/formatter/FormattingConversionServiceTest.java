package com.example.spring_typeconverter.formatter;

import com.example.spring_typeconverter.converter.IpPortToStringConverter;
import com.example.spring_typeconverter.converter.StringToIpPortConverter;
import com.example.spring_typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    public void formattingConversionService() throws Exception {
        //given
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        //컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        //포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        //when
        //컨버터 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8000", IpPort.class);
        //포맷터 사용
        String convert = conversionService.convert(1000, String.class);
        Integer result = conversionService.convert("1,000", Integer.class);
        //then
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8000));
        assertThat(convert).isEqualTo("1,000");
        assertThat(result).isEqualTo(1000);

    }
}
