package com.ztvgzh.computerservice.Models;

public class Cart {
    String productName;
    int price;
    String description;
    String imageUrl;

    public Cart(String productName, int price, String description, String imageUrl) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Cart(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
