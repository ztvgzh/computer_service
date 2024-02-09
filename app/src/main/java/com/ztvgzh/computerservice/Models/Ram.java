package com.ztvgzh.computerservice.Models;

public class Ram {
    private String name;
    private String memorySize;
    private String type;
    private String clockFrequency;
    private String supplyVoltage;
    private String bandwidth;
    private String imageUrl;
    private int price;

    public Ram(){};
    public Ram(String name, String memorySize, String type, String clockFrequency,
               String supplyVoltage, String bandwidth, String imageUrl, int price){
        this.name = name;
        this.memorySize = memorySize;
        this.type = type;
        this.clockFrequency = clockFrequency;
        this.supplyVoltage = supplyVoltage;
        this.bandwidth = bandwidth;
        this.imageUrl = imageUrl;
        this.price = price;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClockFrequency() {
        return clockFrequency;
    }

    public void setClockFrequency(String clockFrequency) {
        this.clockFrequency = clockFrequency;
    }

    public String getSupplyVoltage() {
        return supplyVoltage;
    }

    public void setSupplyVoltage(String supplyVoltage) {
        this.supplyVoltage = supplyVoltage;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
