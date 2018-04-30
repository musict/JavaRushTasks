package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

import com.sun.org.apache.xpath.internal.SourceTree;

public class Calculator {
    public static int plus(int a, int b) {
        return (a + b);
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {

        return (double) a/ b;
    }

    public static double percent(int a, int b) {
        return (double) a / 100 * b;//напишите тут ваш код
    }

    public static void main(String[] args) {
//        System.out.println(division(5,2));
//        System.out.println(percent(5,2));
    }
}