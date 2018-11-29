package com.training.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String title;
    private String description;
    private String author;
    private String contributor;
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getContributor() {
        return contributor;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
