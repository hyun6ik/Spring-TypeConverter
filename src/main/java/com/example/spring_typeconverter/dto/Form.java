package com.example.spring_typeconverter.dto;

import com.example.spring_typeconverter.type.IpPort;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Form {

    private IpPort ipPort;

    public Form(IpPort ipPort) {
        this.ipPort = ipPort;
    }
}
