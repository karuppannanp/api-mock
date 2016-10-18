package com.homedepot.pip.backend.domain;


import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Products {
    private ArrayList<Product> productList;

    public ArrayList<Product> getProductList() {
        return productList;
    }

    @JacksonXmlProperty(localName = "product")
    @JacksonXmlElementWrapper(useWrapping = false)
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

}
