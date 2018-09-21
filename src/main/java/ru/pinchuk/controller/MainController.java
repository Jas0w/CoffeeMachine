package ru.pinchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pinchuk.entity.Coffee;
import ru.pinchuk.entity.CoffeeFactory;
import ru.pinchuk.entity.coffeeMachine.CoffeeMachine;

@Controller
@RestController
public class MainController {

    @Autowired
    CoffeeMachine coffeeMachine;

    @GetMapping("/getCoffee/{type}")
    public CoffeeMachine cappuccino(@PathVariable String type) throws Exception {
        Coffee coffee = CoffeeFactory.createCoffeeByType(type);
        coffeeMachine.getCupOfCoffee(coffee);
        return coffeeMachine;
    }

    @GetMapping("/clean")
    public CoffeeMachine clean() {
        coffeeMachine.cleanMachine();
        return coffeeMachine;
    }

    @GetMapping("/add/{type}/{amount}")
    public CoffeeMachine addMaterial(@PathVariable String type, @PathVariable int amount) {
        if("water".equals(type)) {
            coffeeMachine.addWater(amount);
        } else if("milk".equals(type)) {
            coffeeMachine.addMilk(amount);
        } else if("beans".equals(type)) {
            coffeeMachine.addBeans(amount);
        }
        return coffeeMachine;
    }
}
