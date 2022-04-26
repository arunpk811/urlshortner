package com.pk.demo.repository;

import com.pk.demo.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
    Url findUrlByShortUrl(String shortUrl);
}
