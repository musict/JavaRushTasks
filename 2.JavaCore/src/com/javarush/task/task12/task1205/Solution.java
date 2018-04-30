package com.javarush.task.task12.task1205;

/* 
Или «Корова», или «Кит», или «Собака», или «Неизвестное животное»
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        if (o instanceof Cow) return "Корова";//Напишите тут ваше решение
        if (o instanceof Dog) return "Собака";//Напишите тут ваше решение
        if (o instanceof Whale) return "Кит";//Напишите тут ваше решение
        else
        return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
