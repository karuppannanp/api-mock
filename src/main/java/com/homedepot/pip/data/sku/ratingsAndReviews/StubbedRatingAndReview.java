package com.homedepot.pip.data.sku.ratingsAndReviews;

import com.homedepot.pip.backend.domain.item.ItemRating;
import com.homedepot.pip.input.Rating;

import org.springframework.stereotype.Component;

@Component
public class StubbedRatingAndReview {

	public ItemRating createDefaultItemRating() {
		ItemRating itemRating = new ItemRating();
        itemRating.setRating("4.4962");
        itemRating.setTotalReviews("131");
        return itemRating;
	}
	
	public ItemRating createItemRating(Rating ratingReview) {
		ItemRating itemRating = new ItemRating();
        itemRating.setRating(ratingReview.getRating());
        itemRating.setTotalReviews(ratingReview.getTotalReviews());
        return itemRating;
	}
}