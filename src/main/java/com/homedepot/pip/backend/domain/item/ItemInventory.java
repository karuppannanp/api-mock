package com.homedepot.pip.backend.domain.item;


import com.homedepot.pip.backend.domain.InventoryError;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ItemInventory {

    private String skuNumber;
    private String localStoreId;
    private Integer onHandQuantity;
    private Integer expectedQuantityAvailable;
    private InventoryError error;


    public Integer getOnHandQuantity() {
        return onHandQuantity;
    }

    @JacksonXmlProperty
    public void setOnHandQuantity(Integer onHandQuantity) {
        this.onHandQuantity = onHandQuantity;
    }

    public Integer getExpectedQuantityAvailable() {
        return expectedQuantityAvailable;
    }

    @JacksonXmlProperty
    public void setExpectedQuantityAvailable(Integer expectedQuantityAvailable) {
        this.expectedQuantityAvailable = expectedQuantityAvailable;
    }

    public InventoryError getError() {
        return error;
    }

    @JacksonXmlProperty
    public void setError(InventoryError error) {
        this.error = error;
    }

    public ItemInventory() {
        super();
    }

    public ItemInventory(String skuNumber, String localStoreId,
                         Integer onHandQuantity, Integer expectedQuantityAvailable) {
        super();
        this.skuNumber = skuNumber;
        this.localStoreId = localStoreId;
        this.onHandQuantity = onHandQuantity;
        this.expectedQuantityAvailable = expectedQuantityAvailable;
    }

    public String getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(String skuNumber) {
        this.skuNumber = skuNumber;
    }

    public String getLocalStoreId() {
        return localStoreId;
    }

    public void setLocalStoreId(String localStoreId) {
        this.localStoreId = localStoreId;
    }
}
