package com.javarush.task.task29.task2909.human;

import com.sun.glass.ui.Size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected Size size;
    private BloodGroup bloodGroup;
    private List<Human> children = new ArrayList<>();

    public class Size{
        public int height;
        public int weight;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public String getPosition(){
        return "Человек";
    }
    public Human() {

    }
    public void live() {
    }
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }
    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
    public void addChild(Human human){
        children.add(human);
    }
    public void removeChild(Human human){
        children.remove(human);
    }

    //setter
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    //getter
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }
    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
}