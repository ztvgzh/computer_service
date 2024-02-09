package com.ztvgzh.computerservice.Models;

public class MotherBoard {
    private String name, socket, formFactor, chipset, memorySpeed;
    private int memorySlot, maxMemory, m2Port, sataPort, price;

    public MotherBoard(){}
    public MotherBoard(String name, String socket, String formFactor, String chipset, String memorySpeed,
                       int memorySlot, int maxMemory, int m2Port, int sataPort, int price){
        this.name = name;
        this.socket = socket;
        this.formFactor = formFactor;
        this.chipset = chipset;
        this.memorySpeed = memorySpeed;
        this.memorySlot = memorySlot;
        this.maxMemory = maxMemory;
        this.m2Port = m2Port;
        this.sataPort = sataPort;
        this.price = price;
    }
    public String getName() { return name; }
    public String getSocket() { return socket; }
    public String getFormFactor() { return formFactor; }
    public String getChipset() { return chipset; }
    public String getMemorySpeed() { return memorySpeed; }
    public int getMemorySlot() { return memorySlot; }
    public int getMaxMemory() { return maxMemory; }
    public int getM2Port() { return m2Port; }
    public int getSataPort() { return sataPort; }
    public int getPrice() { return price; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public void setMemorySpeed(String memorySpeed) {
        this.memorySpeed = memorySpeed;
    }

    public void setMemorySlot(int memorySlot) {
        this.memorySlot = memorySlot;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public void setM2Port(int m2Port) {
        this.m2Port = m2Port;
    }

    public void setSataPort(int sataPort) {
        this.sataPort = sataPort;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
