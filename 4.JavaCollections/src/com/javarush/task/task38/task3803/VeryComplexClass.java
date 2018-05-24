package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = new VeryComplexClass();
        String s = (String) o;
    }

    public void methodThrowsNullPointerException() {
        String[] strings = null;
        String s = strings[88];
    }

    public static void main(String[] args) {

    }
}
