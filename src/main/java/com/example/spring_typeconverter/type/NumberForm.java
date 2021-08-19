package com.example.spring_typeconverter.type;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

@Data
public class NumberForm {

    @NumberFormat(pattern = "###,###")
    private Integer number;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    public NumberForm(Integer number, LocalDateTime localDateTime) {
        this.number = number;
        this.localDateTime = localDateTime;
    }
}
