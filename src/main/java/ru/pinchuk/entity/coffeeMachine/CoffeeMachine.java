package ru.pinchuk.entity.coffeeMachine;

import org.springframework.stereotype.Component;
import ru.pinchuk.entity.Coffee;


@Component
public class CoffeeMachine {
    private Reservoir waterReservoir;
    private Reservoir milkReservoir;
    private Reservoir beansReservoir;

    private int cleaningCounter = 0;
    private int maxCleaningCounter = 8;
    private String status = "";


    public CoffeeMachine() {
        waterReservoir = new Reservoir("water", 2000);
        milkReservoir = new Reservoir("milk", 1000);
        beansReservoir = new Reservoir("beans", 150);
    }

    public void getCupOfCoffee(Coffee coffeeType) {
        if (cleaningCounter >= maxCleaningCounter) {
            status = "Coffee machine need to be clean.";
            return;
        }

        if (!isEnoughMaterials(coffeeType)) {
            return;
        }

        createCoffee(coffeeType);

        cleaningCounter++;
    }

    private void createCoffee(Coffee coffee) {
        waterReservoir.takeMaterial(coffee.getWaterRequired());
        milkReservoir.takeMaterial(coffee.getMilkRequired());
        beansReservoir.takeMaterial(coffee.getBeansRequired());

        status = "You got a cup of " + coffee.getType() + ".";
    }

    private boolean isEnoughMaterials(Coffee coffee) {
        boolean waterEnough = waterReservoir.isEnough(coffee.getWaterRequired());
        boolean milkEnough = milkReservoir.isEnough(coffee.getMilkRequired());
        boolean beansEnough = beansReservoir.isEnough(coffee.getBeansRequired());

        if (waterEnough && milkEnough && beansEnough) {
            return true;
        }

        status = "Not enough";
        if (!waterEnough) {
            status += " water";
        }
        if (!milkEnough) {
            status += " milk";
        }
        if (!beansEnough) {
            status += " beans";
        }
        status += ".";

        return false;
    }

    public void cleanMachine() {
        cleaningCounter = 0;
        status = "Coffee Machine has cleaned.";
    }

    public void addWater(int amount) {
        status = waterReservoir.addMaterial(amount);
    }

    public void addMilk(int amount) {
        status = milkReservoir.addMaterial(amount);
    }

    public void addBeans(int amount) {
        status = beansReservoir.addMaterial(amount);
    }

    public String getStatus() {
        return status;
    }

    public Reservoir getWaterReservoir() {
        return waterReservoir;
    }

    public Reservoir getMilkReservoir() {
        return milkReservoir;
    }

    public Reservoir getBeansReservoir() {
        return beansReservoir;
    }
}
