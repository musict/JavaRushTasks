package com.javarush.task.task01.task0136;

/* 
Да хоть на Луну!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeight(888));
    }

    public static double getWeight(int weightEarth) {
        double i = (double)weightEarth / 100 * 17;
        return i;//напишите тут ваш код
    }
}