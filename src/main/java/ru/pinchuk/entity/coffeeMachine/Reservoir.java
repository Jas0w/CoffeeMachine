package ru.pinchuk.entity.coffeeMachine;

public class Reservoir {
    String type;
    private int capacity;
    private int amount;

    Reservoir(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.amount = capacity;
    }

    void takeMaterial(int material) {
        this.amount -= material;
    }

    boolean isEnough(int requires) {
        if(amount < requires) {
            return false;
        }

        return true;
    }

    String addMaterial(int amountToAdd) {
        if(amountToAdd < 0) {
            return "Amount of material cant be less then 0.";
        }

        if((amount + amountToAdd) > capacity) {
            return "Too much " + type + " to add.";
        }

        amount += amountToAdd;

        return "" + type + " successfully added.";
    }

    public int getAmount() {
        return amount;
    }
}
