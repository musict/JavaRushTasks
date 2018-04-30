package com.javarush.task.task21.task2113;

public class Horse {
    private double speed;
    private double distance;
    private String name;

    public Horse(String name, double speed, double distance){
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public String getName(){
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void move(){
        distance += speed * Math.random();
    }
    public void print(){
        for (int i = 0; i < (int)distance; i++) {
            System.out.print(".");
        }
        System.out.println(name);
    }
}
