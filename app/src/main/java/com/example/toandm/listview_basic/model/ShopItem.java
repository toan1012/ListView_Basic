package com.example.toandm.listview_basic.model;

/**
 * Created by toandm on 11/3/17.
 */

public class ShopItem {
    private String oldPrice, newPrice, nameProduct;
    private int img;

    public ShopItem(String oldPrice, String newPrice, String nameProduct, int img) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.nameProduct = nameProduct;
        this.img = img;
    }


    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
