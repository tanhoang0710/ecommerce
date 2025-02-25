package com.dfnltan.ecommerce.common.infrastructure.config.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {
    public static String convertTimeToString(Instant time) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault()).format(time);
    }

    public static String convertLocalDateToString(LocalDate date) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
    }

    public static Instant convertStringToInstant(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
    }

    public static LocalDate convertStringToLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
