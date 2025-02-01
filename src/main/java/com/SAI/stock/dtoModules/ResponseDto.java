package com.SAI.stock.dtoModules;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ResponseDto {

    private int responseCode;
    private String message;
    private Object responseObject;
}
