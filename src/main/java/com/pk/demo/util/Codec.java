package com.pk.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashSet;
import java.util.Set;

public class Codec {
    static Logger logger = LoggerFactory.getLogger(Codec.class);
    static long LEFT_LIMIT = 100000000000L;
    static long RIGHT_LIMIT = 200000000000L;
    static long generatedLong;
    static String elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Set<Long> set = new LinkedHashSet();

    public static String getShortUrl() {
        generatedLong = LEFT_LIMIT + (long) (Math.random() * (LEFT_LIMIT - RIGHT_LIMIT));
        while (set.contains(generatedLong)) {
            generatedLong = LEFT_LIMIT + (long) (Math.random() * (LEFT_LIMIT - RIGHT_LIMIT));
        }
        logger.info(String.valueOf(generatedLong));
        String shortUrl = base10ToBase62(generatedLong);
        set.add(generatedLong);
        return shortUrl;
    }

    private static String base10ToBase62(long n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt((int) (n % 62)));
            n /= 62;
        }
        while (sb.length() != 7) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}