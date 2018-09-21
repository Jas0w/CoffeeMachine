import org.junit.Test;
import ru.pinchuk.entity.Coffee;
import ru.pinchuk.entity.CoffeeFactory;
import ru.pinchuk.entity.coffeeMachine.CoffeeMachine;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void needCleaning() throws Exception {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        for(int i = 0; i <= 8; i++) {
            coffeeMachine.getCupOfCoffee(CoffeeFactory.createCoffeeByType("americano"));
        }

        String expStatus = "Coffee machine need to be clean.";
        assertEquals(coffeeMachine.getStatus(), expStatus);

        coffeeMachine.cleanMachine();

        expStatus = "Machine is cleaned.";
        assertEquals(coffeeMachine.getStatus(), expStatus);
    }

    @Test
    public void getCoffee() throws Exception {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Coffee americano = CoffeeFactory.createCoffeeByType("americano");
        Coffee cappuccino = CoffeeFactory.createCoffeeByType("cappuccino");

        String expAmericano = "U get ur fcking americano.";
        String expCappuccino = "U get ur fcking cappuccino.";

        coffeeMachine.getCupOfCoffee(americano);
        assertEquals(expAmericano, coffeeMachine.getStatus());

        coffeeMachine.getCupOfCoffee(cappuccino);
        assertEquals(expCappuccino, coffeeMachine.getStatus());
    }

    @Test
    public void notEnough() {
        Coffee notEnough = new Coffee("testNotEnough", 2001, 1001, 151);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.getCupOfCoffee(notEnough);
        String expStatus = "Not enough water milk beans.";
        assertEquals(expStatus, coffeeMachine.getStatus());
    }

    @Test
    public void addWater() throws Exception {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        int amount = 20010;
        coffeeMachine.addWater(amount);
        String expStatus = "Too much water to add.";
        assertEquals(expStatus, coffeeMachine.getStatus());

        amount = -200;
        coffeeMachine.addWater(amount);
        expStatus = "Amount of material cant be less then 0.";
        assertEquals(expStatus, coffeeMachine.getStatus());

        coffeeMachine.getCupOfCoffee(CoffeeFactory.createCoffeeByType("cappuccino"));
        amount = 1;
        coffeeMachine.addWater(amount);
        expStatus = "water successfully added.";
        assertEquals(expStatus, coffeeMachine.getStatus());
    }

    @Test
    public void addMilk() throws Exception {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        int amount = 10010;
        coffeeMachine.addMilk(amount);
        String expStatus = "Too much milk to add.";
        assertEquals(expStatus, coffeeMachine.getStatus());

        amount = -200;
        coffeeMachine.addMilk(amount);
        expStatus = "Amount of material cant be less then 0.";
        assertEquals(expStatus, coffeeMachine.getStatus());

        coffeeMachine.getCupOfCoffee(CoffeeFactory.createCoffeeByType("cappuccino"));
        amount = 1;
        coffeeMachine.addMilk(amount);
        expStatus = "milk successfully added.";
        assertEquals(expStatus, coffeeMachine.getStatus());
    }

    @Test
    public void addBeans() throws Exception {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        int amount = 151;
        coffeeMachine.addBeans(amount);
        String expStatus = "Too much beans to add.";
        assertEquals(expStatus, coffeeMachine.getStatus());

        amount = -200;
        coffeeMachine.addBeans(amount);
        expStatus = "Amount of material cant be less then 0.";
        assertEquals(expStatus, coffeeMachine.getStatus());

        coffeeMachine.getCupOfCoffee(CoffeeFactory.createCoffeeByType("cappuccino"));
        amount = 1;
        coffeeMachine.addBeans(amount);
        expStatus = "beans successfully added.";
        assertEquals(expStatus, coffeeMachine.getStatus());
    }
}
