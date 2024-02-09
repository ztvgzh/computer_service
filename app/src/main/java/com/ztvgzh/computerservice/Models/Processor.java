package com.ztvgzh.computerservice.Models;

public class Processor {
    private String processorNumber, lithography, memoryType, intelProcessorGraphics, supportedSocket, imageUrl;
    private int cores, tdp, threads, cache, yearLaunch, price;
    private float maxTurboFrequency, maxMemorySize;


    public Processor(String processorNumber, String lithography, int yearLaunch,
                     String memoryType, String intelProcessorGraphics,
                     String supportedSocket, int cores, int threads,
                     int cache, int tdp, float maxTurboFrequency, int price,
                     float maxMemorySize, String imageUrl) {
        this.processorNumber = processorNumber;
        this.lithography = lithography;
        this.yearLaunch = yearLaunch;
        this.memoryType = memoryType;
        this.intelProcessorGraphics = intelProcessorGraphics;
        this.supportedSocket = supportedSocket;
        this.cores = cores;
        this.threads = threads;
        this.cache = cache;
        this.tdp = tdp;
        this.maxTurboFrequency = maxTurboFrequency;
        this.maxMemorySize = maxMemorySize;
        this.imageUrl = imageUrl;
        this.price = price;
    }
    public Processor(){}

    public Processor(String processorNumber, String imageUrl, int cores, int threads, int price){
        this.processorNumber = processorNumber;
        this.imageUrl = imageUrl;
        this.cores = cores;
        this.threads = threads;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProcessorNumber() {
        return processorNumber;
    }

    public String getLithography() {
        return lithography;
    }

    public int getYearLaunch() {
        return yearLaunch;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public String getIntelProcessorGraphics() {
        return intelProcessorGraphics;
    }

    public String getSupportedSocket() {
        return supportedSocket;
    }

    public int getCores() {
        return cores;
    }

    public int getThreads() {
        return threads;
    }

    public int getCache() {
        return cache;
    }

    public int getTdp() {
        return tdp;
    }

    public float getMaxTurboFrequency() {
        return maxTurboFrequency;
    }

    public float getMaxMemorySize() {
        return maxMemorySize;
    }

    public void setProcessorNumber(String processorNumber) {
        this.processorNumber = processorNumber;
    }

    public void setLithography(String lithography) {
        this.lithography = lithography;
    }

    public void setYearLaunch(int yearLaunch) {
        this.yearLaunch = yearLaunch;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public void setIntelProcessorGraphics(String intelProcessorGraphics) {
        this.intelProcessorGraphics = intelProcessorGraphics;
    }

    public void setSupportedSocket(String supportedSocket) {
        this.supportedSocket = supportedSocket;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public void setTdp(int tdp) {
        this.tdp = tdp;
    }

    public void setMaxTurboFrequency(float maxTurboFrequency) {
        this.maxTurboFrequency = maxTurboFrequency;
    }

    public void setMaxMemorySize(float maxMemorySize) {
        this.maxMemorySize = maxMemorySize;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
