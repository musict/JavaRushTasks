package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }
    public static Car create(int type, int numberOfPassengers){
        switch (type){
            case(TRUCK): return new Truck(numberOfPassengers);
            case(CABRIOLET): return new Cabriolet(numberOfPassengers);
            case(SEDAN): return new Sedan(numberOfPassengers); 
            default: return null;
        }

    }
    public void fill(double numberOfLiters) throws Exception {
            if (numberOfLiters > 0) {
                fuel += numberOfLiters;
            }
            else {
                throw new Exception();
            }




    }
    public boolean isDriverAvailable() {
        return driverAvailable;
    }
    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();

    }
    public void fastenPassengersBelts() {
    }
    public void fastenDriverBelt() {
    }
    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        return date.before(summerEnd) && date.after(summerStart);
    }
    public double getWinterConsumption(int length){
        return winterFuelConsumption*length + winterWarmingUp;
    }
    public double getSummerConsumption(int length){
        return summerFuelConsumption*length;
    }
    private boolean canPassengersBeTransferred(){
        return (driverAvailable && fuel > 0);
    }

    //setter
    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }
    //getter
    public abstract int getMaxSpeed();
    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()){
            return numberOfPassengers;
        }
        else {
            return 0;
        }
    }
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd))
        {
            return getSummerConsumption(length);
        } else
            return getWinterConsumption(length);
    }

}