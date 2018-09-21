package ru.pinchuk.entity;

import org.springframework.stereotype.Component;


@Component
public class CoffeeFactory {

    public static Coffee createCoffeeByType(String type) throws Exception {
        if(type.equalsIgnoreCase("cappuccino")) {
            return new Coffee("cappuccino", 150, 100, 15);
        } else if(type.equalsIgnoreCase("americano")) {
            return new Coffee("americano", 200, 0, 15);
        } else {
            throw new Exception("Unknown coffee type.");
        }
    }
}
