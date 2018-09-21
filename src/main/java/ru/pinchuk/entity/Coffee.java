package ru.pinchuk.entity;

public class Coffee {
    private String type;
    private int waterRequired;
    private int milkRequired;
    private int beansRequired;

    public Coffee(String type, int waterRequired, int milkRequired, int beansRequired) {
        this.type = type;
        this.waterRequired = waterRequired;
        this.milkRequired = milkRequired;
        this.beansRequired = beansRequired;
    }

    public String getType() {
        return type;
    }

    public int getWaterRequired() {
        return waterRequired;
    }

    public int getMilkRequired() {
        return milkRequired;
    }

    public int getBeansRequired() {
        return beansRequired;
    }
}
