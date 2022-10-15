package com.sprint.common.utils;

import com.sprint.common.constants.Constants;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Utils {

    public static LocalDateTime stringToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return dateTime;
    }

    public static String encodePassword(String data) {
        return Base64.getUrlEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }
}
