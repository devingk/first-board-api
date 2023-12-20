package com.devingk.firstboard.test.util;

import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;

public class TestTimeUtil {

    public static void setDateTime(Object object) {
        ReflectionTestUtils.setField(object, "createdAt", LocalDateTime.now());
        ReflectionTestUtils.setField(object, "modifiedAt", LocalDateTime.now());
    }
}
