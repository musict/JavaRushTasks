package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

//    для тестов****************************

    public Order(Tablet tablet, Date date) throws IOException{
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrderTest();
    }
//    **************************************

    @Override
    public String toString() {
        if (dishes.size() == 0 || dishes.isEmpty() || dishes == null) {
            return "";
        } else {
            return "Your order: " + dishes + " of "+ tablet.toString() + "  cooking time " + getTotalCookingTime() + "min ";
        }
    }

    public int getTotalCookingTime() {
        int timeCooking = 0;
        for (Dish dish : dishes) timeCooking += dish.getDuration();
        return timeCooking;
    }

    public boolean isEmpty() {
        if (dishes.isEmpty() || dishes == null) {
            return true;
        } else {
            return false;
        }
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
