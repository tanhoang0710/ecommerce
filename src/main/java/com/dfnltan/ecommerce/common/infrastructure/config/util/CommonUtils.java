package com.dfnltan.ecommerce.common.infrastructure.config.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@UtilityClass
public class CommonUtils {
    private static final String MASKED_DISPLAY = "***";
    private static final String MASKED_PHONE = "******";

    public static String maskedLongPhoneNumber(String phoneNumber, int displayNum) {
        return MASKED_PHONE + StringUtils.substring(phoneNumber, phoneNumber.length() - displayNum);
    }

    public static String maskedPhoneNumber(String phoneNumber, int displayNum) {
        return MASKED_DISPLAY + StringUtils.substring(phoneNumber, phoneNumber.length() - displayNum);
    }

    public static String maskedEmail(String email, int displayNum) {
        var spliced = StringUtils.split(email, "@");
        if (Objects.isNull(spliced) || spliced.length == 0) {
            return "";
        }

        var masked = StringUtils.substring(spliced[0], 0, displayNum) + MASKED_DISPLAY;

        if (spliced.length > 1) {
            masked = masked + "@" + spliced[1];
        }

        return masked;
    }
}
