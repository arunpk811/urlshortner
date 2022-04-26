package com.pk.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document("custom_urls")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomUrl {
    @Id
    private String shortUrl;
    private String actualUrl;
    private long userId;
    private LocalDate expiryDate;
}
