package com.pk.demo.controller;

import com.pk.demo.model.Url;
import com.pk.demo.service.CustomUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.pk.demo.service.UrlService;


@RestController
public class MainController {
    static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UrlService urlService;

    @Autowired
    CustomUrlService customUrlService;

    @GetMapping("/{shortURL}")
    public RedirectView redirect(@PathVariable String shortURL){
        String actualUrl = urlService.getActualUrl(shortURL);
        logger.info(actualUrl);
        RedirectView redirectView = new RedirectView();
        if(actualUrl==null || actualUrl.equals("")){
            redirectView.setUrl("");
            redirectView.setStatusCode(HttpStatus.NOT_FOUND);
        } else {
            redirectView.setStatusCode(HttpStatus.FOUND);
            redirectView.setUrl(actualUrl);
        }
        return redirectView;
    }

    @PostMapping("/shorturl")
    public String createShortUrl(@RequestBody String actualUrl) {
        return urlService.createShortUrl(actualUrl);
    }

    @PostMapping("/customurl/{expiryDate}/{userId}")
    public String createShortUrl(@RequestBody Url url, @PathVariable String expiryDate, @PathVariable long userId) {
        return customUrlService.createCustomShortUrl(url.getActualUrl(), expiryDate, userId);
    }
}
