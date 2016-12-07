package com.homedepot.pip.backend.domain.item;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.homedepot.pip.backend.domain.Media;

public class ItemMedia {

    private Boolean imageEnhancementFlag;
    private ArrayList<Media> mediaList;

    public Boolean getImageEnhancementFlag() {
        return imageEnhancementFlag;
    }

    @JacksonXmlProperty
    public void setImageEnhancementFlag(Boolean imageEnhancementFlag) {
        this.imageEnhancementFlag = imageEnhancementFlag;
    }

    public ArrayList<Media> getMediaList() {
        return mediaList;
    }

    @JacksonXmlProperty(localName = "mediaEntry")
	@JacksonXmlElementWrapper(useWrapping = false)
    public void setMediaList(ArrayList<Media> mediaList) {
        this.mediaList = mediaList;
    }
}