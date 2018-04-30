package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    public void fight() {
    }
    public void live() {
        fight();
    }

    public Soldier(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
