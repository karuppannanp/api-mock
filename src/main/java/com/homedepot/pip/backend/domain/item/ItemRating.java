package com.homedepot.pip.backend.domain.item;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ItemRating {
    private String rating;
    private String totalReviews;

    public String getRating() {
        return rating;
    }

    @JacksonXmlProperty(localName = "averageRating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTotalReviews() {
        return totalReviews;
    }

    @JacksonXmlProperty
    public void setTotalReviews(String totalReviews) {
        this.totalReviews = totalReviews;
    }
}
