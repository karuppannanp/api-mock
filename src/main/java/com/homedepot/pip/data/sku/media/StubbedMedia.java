package com.homedepot.pip.data.sku.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.homedepot.pip.backend.domain.Media;
import com.homedepot.pip.backend.domain.item.ItemMedia;
import com.homedepot.pip.input.MediaInput;

@Component
public class StubbedMedia {
	
	private static final String[] IMAGE_SIZES = { "65", "100", "145", "300", "400", "600", "1000" };
	
	private static final String[] IMAGE_TYPES = { "IMAGE", "IMAGE_LEFT_VIEW", "IMAGE_RIGHT_VIEW", "IMAGE_TOP_VIEW",
			"IMAGE_BOTTOM_VIEW", "IMAGE_BACK_VIEW", "IMAGE_OPEN_VIEW", "IMAGE_ALTERNATE_VIEW", "IMAGE_ALTERNATE_VIEW_2",
			"IMAGE_ALTERNATE_VIEW_3", "IMAGE_ALTERNATE_VIEW_4", "IMAGE_ALTERNATE_VIEW_5", "IMAGE_ALTERNATE_VIEW_6",
			"IMAGE_CATALOG_VIEW", "IMAGE_LIFE_STYLE" };
	
	private static final Map<String, String> IMAGE_TYPE_GUID_MAPPING = new HashMap<>();
	
	static {
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[0], "fa44ab91-78eb-4e86-8928-995abe6aa993");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[1], "7980e235-c347-4a5a-bdde-2b6db7a1e2c6");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[2], "cb37d1d6-1d79-4ba3-b3a3-ad2a55349793");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[3], "ed044414-da28-4366-badf-30ccff409159");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[4], "da368396-fc92-454a-9918-89b4fb3ba162");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[5], "648154fa-5e61-4806-8348-5a14b072c92f");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[6], "f927210d-1573-4cb3-96f2-dbe4e06b1e84");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[7], "e98a8683-f2a8-4d40-a782-2069d5f19ddc");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[8], "06826dd4-7eeb-4d8a-8b3f-9f2038f010d6");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[9], "3449f003-ce25-4822-b8fd-f203233d5e59");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[10], "5757aafd-4760-443c-a0ce-0700e7fcb8d6");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[11], "f92bdef1-8c4d-453c-b7ef-a71b54a61485");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[12], "b29b1d21-f305-456a-a3f9-933c15368d60");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[13], "35e388d4-7f34-4a66-aeff-777f2a6f9bce");
		IMAGE_TYPE_GUID_MAPPING.put(IMAGE_TYPES[14], "58778523-850b-4bbf-93eb-3d38b4c8c8cc");
	}

	public ItemMedia createDefaultItemMedia() {
		ItemMedia itemMedia = new ItemMedia();
		createImageItemMedia(itemMedia, -1);
		createVideoItemMedia(itemMedia, 3);
		return itemMedia;
	}

	public ItemMedia createItemMedia(MediaInput media) {
		ItemMedia itemMedia = new ItemMedia();
		createImageItemMedia(itemMedia, media.getNoOfImages());
		createVideoItemMedia(itemMedia, media.getNoOfVideos());
		return itemMedia;
	}

	private ItemMedia createVideoItemMedia(ItemMedia itemMedia, int noOfVideos) {
		if (noOfVideos == -1) {
			noOfVideos = 6;
		}
		if (noOfVideos > 0) {
			ArrayList<Media> mediaList = itemMedia.getMediaList();
			if (noOfVideos >= 1) {
				mediaList.add(createVideo1());
			}
			if (noOfVideos >= 2) {
				mediaList.add(createVideo2());				
			}
			if (noOfVideos >= 3) {
				mediaList.add(createVideo3());				
			}
			if (noOfVideos >= 4) {
				mediaList.add(createVideo4());				
			}
			if (noOfVideos >= 5) {
				mediaList.add(createVideo5());				
			}
			if (noOfVideos >= 6) {
				mediaList.add(createVideo6());				
			}
		}
		return itemMedia;
	}
	
	private Media createVideo1() {
		Media media = new Media();
		media.setType("BRIGHTCOVE VIDEO");
		media.setVideoId("4110224631001");
		media.setThumbnail("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4110226361001_4-e98otubg7s9qhhklv8f0xp8tbhkbdeak-2031426282239691-file-th.jpg?pubId=1834613806001");
		media.setVideo("http://brightcove.vo.llnwd.net/e1/uds/pd/1834613806001/1834613806001_4110226993001_4-e98otubg7s9qhhklv8f0xp8tbhkbdeak-2031426282239691-file.mp4");
		media.setTitle("20volt-max-lithiumion-cordless-drillldriver-kit");
		media.setShortDescription("20volt-max-lithiumion-cordless-drillldriver-kit");
		media.setVideoStill("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4110226358001_4-e98otubg7s9qhhklv8f0xp8tbhkbdeak-2031426282239691-file-vs.jpg?pubId=1834613806001");
		return media;
	}
	
	private Media createVideo2() {
		Media media = new Media();
		media.setType("BRIGHTCOVE VIDEO");
		media.setVideoId("4110231211001");
		media.setThumbnail("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4110201398001_4-e98otubg7s9qhhklv8f0xp8tbhkbdeak-8701426281490084-file-th.jpg?pubId=1834613806001");
		media.setVideo("http://brightcove.vo.llnwd.net/e1/uds/pd/1834613806001/1834613806001_4110201679001_4-e98otubg7s9qhhklv8f0xp8tbhkbdeak-8701426281490084-file.mp4");
		media.setTitle("18volt-nicad-1l2-in-compact-drillldriver-kit");
		media.setShortDescription("18volt-nicad-1l2-in-compact-drillldriver-kit");
		media.setVideoStill("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4110201397001_4-e98otubg7s9qhhklv8f0xp8tbhkbdeak-8701426281490084-file-vs.jpg?pubId=1834613806001");
		return media;
	}
	
	private Media createVideo3() {
		Media media = new Media();
		media.setType("BRIGHTCOVE VIDEO");
		media.setVideoId("3578072360001");
		media.setThumbnail("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_3577967935001_301-1823bc4fa2e63ff353f9c5d6665d8d29-5371400607289433-file-th.jpg?pubId=1834613806001");
		media.setVideo("http://brightcove.vo.llnwd.net/e1/uds/pd/1834613806001/1834613806001_3577968024001_301-1823bc4fa2e63ff353f9c5d6665d8d29-5371400607289433-file.mp4");
		media.setTitle("RF30HBEDBSR Food Showcase Refrigerator");
		media.setShortDescription("RF30HBEDBSR Food Showcase Refrigerator");
		media.setVideoStill("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_3577967933001_301-1823bc4fa2e63ff353f9c5d6665d8d29-5371400607289433-file-vs.jpg?pubId=1834613806001");
		return media;
		
	}
	
	private Media createVideo4() {
		Media media = new Media();
		media.setType("BRIGHTCOVE VIDEO");
		media.setVideoId("4287896923001");
		media.setThumbnail("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4277727562001_4277711979001-th.jpg?pubId=1834613806001");
		media.setVideo("http://brightcove.vo.llnwd.net/e1/uds/pd/1834613806001/1834613806001_4277727561001_4277711979001.mp4");
		media.setTitle("Food Showcase");
		media.setShortDescription("Video showing the Food Showcase dual door technology.");
		media.setVideoStill("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4277727563001_4277711979001-vs.jpg?pubId=1834613806001");
		return media;
	}
	
	private Media createVideo5() {
		Media media = new Media();
		media.setType("BRIGHTCOVE VIDEO");
		media.setVideoId("4287930886001");
		media.setThumbnail("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4277650313001_4277633925001-th.jpg?pubId=1834613806001");
		media.setVideo("http://brightcove.vo.llnwd.net/e1/uds/pd/1834613806001/1834613806001_4277641445001_4277633925001.mp4");
		media.setTitle("FlexZone Drawer");
		media.setShortDescription("Counter-Height FlexZone Drawer");
		media.setVideoStill("http://brightcove.vo.llnwd.net/e1/pd/1834613806001/1834613806001_4277650312001_4277633925001-vs.jpg?pubId=1834613806001");
		return media;
	}
	
	private Media createVideo6() {
		Media media = new Media();
		media.setType("BRIGHTCOVE VIDEO");
		media.setVideoId("5088539496001");
		media.setThumbnail("http://brightcove04.o.brightcove.com/66036796001/66036796001_5088544416001_5088539496001-th.jpg?pubId=66036796001");
		media.setVideo("http://uds.ak.o.brightcove.com/66036796001/66036796001_5088543465001_5088539496001.mp4");
		media.setTitle("Home Depot Refrigerator Delivery & Installation");
		media.setShortDescription("This video will walk you through the simple steps you must take in order to ensure a successful delivery and installation of your new Refrigerator from The Home Depot.");
		media.setVideoStill("http://brightcove04.o.brightcove.com/66036796001/66036796001_5088544415001_5088539496001-vs.jpg?pubId=66036796001");
		return media;
	}

	private ItemMedia createImageItemMedia(ItemMedia itemMedia, int noOfImages) {
		int imagesNeeded = IMAGE_TYPES.length;
		if (noOfImages > 0 && noOfImages <= imagesNeeded) {
			imagesNeeded = noOfImages;
		}

		itemMedia.setImageEnhancementFlag(true);
		ArrayList<Media> mediaList = new ArrayList<>();
		for (String imageSize : IMAGE_SIZES) {
			for (int count = 0; count < imagesNeeded; count++) {
				addImageMedia(mediaList, IMAGE_TYPES[count], IMAGE_TYPE_GUID_MAPPING.get(IMAGE_TYPES[count]),
						imageSize);
			}
		}

		itemMedia.setMediaList(mediaList);
		return itemMedia;
	}

	private String formatImageUrl(String mediaGuid, String mediaSize) {
		StringBuilder productImageUrl = new StringBuilder();
		if (mediaGuid != null && mediaGuid.length() > 2) {
			productImageUrl.append("http://www.homedepot.com");
			productImageUrl.append("/catalog/productImages/").append(mediaSize).append("/");
			productImageUrl.append(mediaGuid.substring(0, 2)).append("/");
			productImageUrl.append(mediaGuid).append("_").append(mediaSize).append(".jpg");
		}
		return productImageUrl.toString();
	}

	private Media createImageMediaType(String mediaGuid, String mediaType, String mediaSize, String location) {
		Media media = new Media();
		media.setHeight(mediaSize);
		media.setWidth(mediaSize);
		media.setType(mediaType);
		if (location == null) {
			media.setLocation(formatImageUrl(mediaGuid, mediaSize));
		}
		return media;
	}
	
	private void addImageMedia(ArrayList<Media> mediaList, String imageType, String guid, String imageSize) {
		mediaList.add(createImageMediaType(guid, imageType, imageSize, null));
	}
}