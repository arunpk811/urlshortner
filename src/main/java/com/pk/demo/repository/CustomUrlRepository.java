package com.pk.demo.repository;

import com.pk.demo.model.CustomUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomUrlRepository extends MongoRepository<CustomUrl, String> {
    CustomUrl getUrlByShortUrl(String shortUrl);
}
