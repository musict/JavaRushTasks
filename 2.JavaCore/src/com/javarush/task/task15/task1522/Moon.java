package com.javarush.task.task15.task1522;

/**
 * Created by Python on 23.03.2017.
 */
public class Moon implements Planet {
    private static Moon instance;

    public static Moon getInstance() {
        if (instance == null){
            instance = new Moon();
        }
        return instance;
    }
    protected Moon() {
    }
}
