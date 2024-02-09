package com.ztvgzh.computerservice.Models;

public class Videocard {
    private String name;
    private String videoMemorySize;
    private String memoryType;
    private String memoryFrequency;
    private String maxResolution;
    private String memoryExchangeBus;
    private String videoProcessorFrequency;
    private String connectionType;
    private String imageUrl;
    private int	tdp, numOfSupportedMonitors, price;

    public Videocard(){}
    public Videocard(String name, String videoMemorySize, String memoryType, String memoryFrequency, String maxResolution,
                     String memoryExchangeBus, String videoProcessorFrequency, String connectionType, String imageUrl,
                     int tdp, int numOfSupportedMonitors, int price){
        this.name = name;
        this.videoMemorySize = videoMemorySize;
        this.memoryType = memoryType;
        this.memoryFrequency = memoryFrequency;
        this.maxResolution = maxResolution;
        this.memoryExchangeBus = memoryExchangeBus;
        this.videoProcessorFrequency = videoProcessorFrequency;
        this.connectionType = connectionType;
        this.imageUrl = imageUrl;
        this.tdp = tdp;
        this.numOfSupportedMonitors = numOfSupportedMonitors;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoMemorySize() {
        return videoMemorySize;
    }

    public void setVideoMemorySize(String videoMemorySize) {
        this.videoMemorySize = videoMemorySize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getMemoryFrequency() {
        return memoryFrequency;
    }

    public void setMemoryFrequency(String memoryFrequency) {
        this.memoryFrequency = memoryFrequency;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public String getMemoryExchangeBus() {
        return memoryExchangeBus;
    }

    public void setMemoryExchangeBus(String memoryExchangeBus) {
        this.memoryExchangeBus = memoryExchangeBus;
    }

    public String getVideoProcessorFrequency() {
        return videoProcessorFrequency;
    }

    public void setVideoProcessorFrequency(String videoProcessorFrequency) {
        this.videoProcessorFrequency = videoProcessorFrequency;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTdp() {
        return tdp;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    public int getNumOfSupportedMonitors() {
        return numOfSupportedMonitors;
    }

    public void setNumOfSupportedMonitors(int numOfSupportedMonitors) {
        this.numOfSupportedMonitors = numOfSupportedMonitors;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
