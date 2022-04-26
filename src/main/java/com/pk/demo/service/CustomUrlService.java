package com.pk.demo.service;

import com.pk.demo.model.CustomUrl;
import com.pk.demo.repository.CustomUrlRepository;
import com.pk.demo.util.Codec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Service
public class CustomUrlService {
    private static final String ZAGENO_URL = "http://zageno.url/";
    @Autowired
    CustomUrlRepository customUrlRepository;

    public String createCustomShortUrl(String actualUrl, String expiryDate, long userId) {
        String shortUrl = Codec.getShortUrl();
        customUrlRepository.save(
                CustomUrl.builder()
                        .shortUrl(shortUrl)
                        .actualUrl(actualUrl)
                        .expiryDate(LocalDate.parse(expiryDate))
                        .userId(userId)
                        .build());
        return ZAGENO_URL + shortUrl;
    }
}
