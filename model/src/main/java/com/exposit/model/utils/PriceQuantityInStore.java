package com.exposit.model.utils;

public class PriceQuantityInStore {
    private Integer goodsPrice;
    private Integer goodsQuantity;
    private  String storeName;

    public PriceQuantityInStore(String storeName, Integer goodsQuantity,Integer goodsPrice ) {
        this.goodsPrice = goodsPrice;
        this.goodsQuantity = goodsQuantity;
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return  "storeName='" + storeName +
                ", goodsQuantity=" + goodsQuantity +
                ", goodsPrice=" + goodsPrice ;
    }
}
