package com.pk.demo.service;

import com.pk.demo.model.CustomUrl;
import com.pk.demo.model.Url;
import com.pk.demo.repository.CustomUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pk.demo.repository.UrlRepository;
import com.pk.demo.util.Codec;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;


@Service
public class UrlService {
    private final String ZAGENO_URL="http://zageno.url/";

    @Autowired
    UrlRepository urlRepository;

    public String createShortUrl(String actualUrl) {
        String shortUrl = Codec.getShortUrl();
        urlRepository.save(
                Url.builder()
                        .shortUrl(shortUrl)
                        .actualUrl(actualUrl)
                .build());
        return ZAGENO_URL + shortUrl;
    }

    public String getActualUrl(String shortUrl) {
        return urlRepository.findUrlByShortUrl(shortUrl).getActualUrl();
    }
}
