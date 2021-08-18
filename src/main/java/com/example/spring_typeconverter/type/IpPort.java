package com.example.spring_typeconverter.type;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class IpPort {

    private String ip;
    private int port;

    @Builder
    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public static IpPort of(String ip, int port) {
        return new IpPort().builder()
                .ip(ip)
                .port(port)
                .build();
    }
}
