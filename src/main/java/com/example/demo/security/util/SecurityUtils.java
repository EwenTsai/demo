package com.example.demo.security.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(SecurityUtils.class);

    private volatile static BCryptPasswordEncoder bCryptPasswordEncoder;

    private SecurityUtils() {}

    public static BCryptPasswordEncoder getPasswordEncoder() {
        if (bCryptPasswordEncoder == null) {
            synchronized (SecurityUtils.class) {
                if (bCryptPasswordEncoder == null) {
                    bCryptPasswordEncoder = new BCryptPasswordEncoder();
                    LOGGER.info("BCryptPasswordEncoder initialized");
                }
            }
        }
        return bCryptPasswordEncoder;
    }

    public static String encode(String text) {
        return bCryptPasswordEncoder.encode(text);
    }

    public static boolean matches(String text, String cipher) {
        return bCryptPasswordEncoder.matches(text, cipher);
    }

}
