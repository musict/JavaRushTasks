package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public List getHorses(){
        return horses;
    }
    public Hippodrome(List list){
        this.horses = list;
    }

    static Hippodrome game;

    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("One", 3, 0));
        horses.add(new Horse("Two", 3, 0));
        horses.add(new Horse("Three", 3, 0));
        game = new Hippodrome(horses);
        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game.printWinner();


    }
    public void move(){
        for (Horse h : horses) {
            h.move();
        }
    }
    public void print(){
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public Horse getWinner(){
        int maxDistance = 0;
        Horse horse = null;
        for (Horse h:horses) {
            if (h.getDistance() > maxDistance){
                maxDistance = (int) h.getDistance();
                horse = h;
            }
        }
        return horse;

    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
