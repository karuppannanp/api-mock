package com.homedepot.pip.backend.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Media  {

    private String mediaType;
    private String title;
    private String shortDescription;
    private String longDescription;
    private String location;
    private String height;
    private String width;
    private String videoId;
    private String thumbnail;
    private String video;
    private String videoStill;

    public String getVideoId() {
        return videoId;
    }

    @JacksonXmlProperty
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getType() {
        return mediaType;
    }

    @JacksonXmlProperty(localName = "mediaType")
    public void setType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getTitle() {
        return title;
    }

    @JacksonXmlProperty
    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    @JacksonXmlProperty
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    @JacksonXmlProperty
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getLocation() {
        return location;
    }

    @JacksonXmlProperty
    public void setLocation(String location) {
        this.location = location;
    }

    public String getHeight() {
        return height;
    }

    @JacksonXmlProperty
    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    @JacksonXmlProperty
    public void setWidth(String width) {
        this.width = width;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @JacksonXmlProperty
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideo() {
        return video;
    }

    @JacksonXmlProperty
    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoStill() {
        return videoStill;
    }

    @JacksonXmlProperty
    public void setVideoStill(String videoStill) {
        this.videoStill = videoStill;
    }
}
