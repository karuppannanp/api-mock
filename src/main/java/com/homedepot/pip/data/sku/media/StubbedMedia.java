package com.homedepot.pip.data.sku.media;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.Media;
import com.homedepot.pip.backend.domain.item.ItemMedia;

@Component
public class StubbedMedia {
	
public ItemMedia createDefaultItemMediaTypeImage() {
        ItemMedia itemMedia = new ItemMedia();
        itemMedia.setImageEnhancementFlag(true);
        ArrayList<Media> mediaList = new ArrayList<>();
        mediaList.add(createMediaTypeImage("fa44ab91-78eb-4e86-8928-995abe6aa993", "IMAGE", "65", null));
        mediaList.add(createMediaTypeImage("da368396-fc92-454a-9918-89b4fb3ba162", "IMAGE_BOTTOM_VIEW", "65", null));
        mediaList.add(createMediaTypeImage("648154fa-5e61-4806-8348-5a14b072c92f", "IMAGE_BACK_VIEW", "65", null));
        mediaList.add(createMediaTypeImage("e98a8683-f2a8-4d40-a782-2069d5f19ddc", "IMAGE_ALTERNATE_VIEW", "65", null));
        mediaList.add(createMediaTypeImage("fa44ab91-78eb-4e86-8928-995abe6aa993", "IMAGE", "100", null));
        mediaList.add(createMediaTypeImage("da368396-fc92-454a-9918-89b4fb3ba162", "IMAGE_BOTTOM_VIEW", "100", null));
        mediaList.add(createMediaTypeImage("648154fa-5e61-4806-8348-5a14b072c92f", "IMAGE_BACK_VIEW", "100", null));
        mediaList.add(createMediaTypeImage("e98a8683-f2a8-4d40-a782-2069d5f19ddc", "IMAGE_ALTERNATE_VIEW", "100", null));
        mediaList.add(createMediaTypeImage("fa44ab91-78eb-4e86-8928-995abe6aa993", "IMAGE", "145", null));
        mediaList.add(createMediaTypeImage("da368396-fc92-454a-9918-89b4fb3ba162", "IMAGE_BOTTOM_VIEW", "145", null));
        mediaList.add(createMediaTypeImage("648154fa-5e61-4806-8348-5a14b072c92f", "IMAGE_BACK_VIEW", "145", null));
        mediaList.add(createMediaTypeImage("e98a8683-f2a8-4d40-a782-2069d5f19ddc", "IMAGE_ALTERNATE_VIEW", "145", null));
        mediaList.add(createMediaTypeImage("fa44ab91-78eb-4e86-8928-995abe6aa993", "IMAGE", "300", null));
        mediaList.add(createMediaTypeImage("da368396-fc92-454a-9918-89b4fb3ba162", "IMAGE_BOTTOM_VIEW", "300", null));
        mediaList.add(createMediaTypeImage("648154fa-5e61-4806-8348-5a14b072c92f", "IMAGE_BACK_VIEW", "300", null));
        mediaList.add(createMediaTypeImage("e98a8683-f2a8-4d40-a782-2069d5f19ddc", "IMAGE_ALTERNATE_VIEW", "300", null));
        mediaList.add(createMediaTypeImage("fa44ab91-78eb-4e86-8928-995abe6aa993", "IMAGE", "400", null));
        mediaList.add(createMediaTypeImage("da368396-fc92-454a-9918-89b4fb3ba162", "IMAGE_BOTTOM_VIEW", "400", null));
        mediaList.add(createMediaTypeImage("648154fa-5e61-4806-8348-5a14b072c92f", "IMAGE_BACK_VIEW", "400", null));
        mediaList.add(createMediaTypeImage("e98a8683-f2a8-4d40-a782-2069d5f19ddc", "IMAGE_ALTERNATE_VIEW", "400", null));
        mediaList.add(createMediaTypeImage("fa44ab91-78eb-4e86-8928-995abe6aa993", "IMAGE", "600", null));
        mediaList.add(createMediaTypeImage("da368396-fc92-454a-9918-89b4fb3ba162", "IMAGE_BOTTOM_VIEW", "600", null));
        mediaList.add(createMediaTypeImage("648154fa-5e61-4806-8348-5a14b072c92f", "IMAGE_BACK_VIEW", "600", null));
        mediaList.add(createMediaTypeImage("e98a8683-f2a8-4d40-a782-2069d5f19ddc", "IMAGE_ALTERNATE_VIEW", "600", null));
        mediaList.add(createMediaTypeImage("fa44ab91-78eb-4e86-8928-995abe6aa993", "IMAGE", "1000", null));
        mediaList.add(createMediaTypeImage("da368396-fc92-454a-9918-89b4fb3ba162", "IMAGE_BOTTOM_VIEW", "1000", null));
        mediaList.add(createMediaTypeImage("648154fa-5e61-4806-8348-5a14b072c92f", "IMAGE_BACK_VIEW", "1000", null));
        mediaList.add(createMediaTypeImage("e98a8683-f2a8-4d40-a782-2069d5f19ddc", "IMAGE_ALTERNATE_VIEW", "1000", null));
        itemMedia.setMediaList(mediaList);
        return itemMedia;
	}

	public String formatImageUrl(String mediaGuid, String mediaSize) {
		StringBuilder productImageUrl = new StringBuilder();
		if (mediaGuid != null && mediaGuid.length() > 2) {
			productImageUrl.append("http://www.homedepot.com");
			productImageUrl.append("/catalog/productImages/").append(mediaSize).append("/");
			productImageUrl.append(mediaGuid.substring(0, 2)).append("/");
			productImageUrl.append(mediaGuid).append("_").append(mediaSize).append(".jpg");
		}
		return productImageUrl.toString();
	}
	
	public Media createMediaTypeImage(String mediaGuid, String mediaType, String mediaSize, String location ) {
		Media media = new Media();
		media.setHeight(mediaSize);
		media.setWidth(mediaSize);
		media.setType(mediaType);
		if (location == null) {
			media.setLocation(formatImageUrl(mediaGuid, mediaSize));
		}
		return media;
	}
}