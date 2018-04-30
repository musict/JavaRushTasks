package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;

import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

import java.util.Locale;
import java.util.Observer;


public class Restaurant {
    public static void main(String[] args) throws IOException{
        Locale.setDefault(Locale.ENGLISH);
        Tablet tablet = new Tablet(5);
        Cook amigo = new Cook("Amigo");
        Waiter waitor = new Waiter();
        DirectorTablet directorTablet= new DirectorTablet();
        amigo.addObserver(waitor);
        tablet.addObserver((Observer) amigo);
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();


        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();

    }
}
