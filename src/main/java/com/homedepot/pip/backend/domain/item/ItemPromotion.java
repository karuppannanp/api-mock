package com.homedepot.pip.backend.domain.item;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.homedepot.pip.backend.domain.Promotion;

public class ItemPromotion {

	private Boolean itemHasRebates;
    private String mailInRebateFormURL;
    private ArrayList<Promotion> promotionList;

    public ArrayList<Promotion> getPromotionList() {
        return promotionList;
    }

    @JacksonXmlProperty(localName = "promotionEntry")
    @JacksonXmlElementWrapper(useWrapping = false)
    public void setPromotionList(ArrayList<Promotion> promotionList) {
        this.promotionList = promotionList;
    }

    public String getMailInRebateFormURL() {
        return this.mailInRebateFormURL;
    }

    @JacksonXmlProperty
    public void setMailInRebateFormURL(String mailInRebateFormURL) {
        this.mailInRebateFormURL = mailInRebateFormURL;
    }

    public Boolean getItemHasRebates() {
        return itemHasRebates;
    }

    @JacksonXmlProperty
    public void setItemHasRebates(Boolean itemHasRebates) {
        this.itemHasRebates = itemHasRebates;
    }

}
