package com.SAI.stock.commonUtil;

import com.SAI.stock.dtoModules.ResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommonUtil {

    public static String getCurrentDate() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime now = LocalDateTime.now();
        return timeFormatter.format(now);
    }

    public static ResponseDto createResponse(int code, String message, Object responseObject) {
        return new ResponseDto(code,message,responseObject);
    }
}
