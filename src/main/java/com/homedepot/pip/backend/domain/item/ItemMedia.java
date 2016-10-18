package com.homedepot.pip.backend.domain.item;

import com.homedepot.pip.backend.domain.Media;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;

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
    public void setMediaList(ArrayList<Media> mediaList) {
        this.mediaList = mediaList;
    }
}