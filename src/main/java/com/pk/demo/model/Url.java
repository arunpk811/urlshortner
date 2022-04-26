package com.pk.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("urls")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Url {
    @Id
    private String shortUrl;
    private String actualUrl;
}
