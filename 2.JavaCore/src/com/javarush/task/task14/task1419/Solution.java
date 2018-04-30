package com.javarush.task.task14.task1419;

import java.io.EOFException;
import java.io.IOError;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.lang.invoke.LambdaConversionException;
import java.security.KeyException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.UnknownFormatConversionException;
import java.util.jar.JarException;

/* 
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        initExceptions1();
        initExceptions2();
        initExceptions3();
        initExceptions4();
        initExceptions5();
        initExceptions6();
        initExceptions7();
        initExceptions8();
        initExceptions9();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions1() {   //it's first exception
        try {
            exceptions.get(99);

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions2() {   //it's first exception
        try {
            throw new EOFException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions3() {   //it's first exception
        try {
            throw new IOException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions4() {   //it's first exception
        try {
            throw new NegativeArraySizeException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions5() {   //it's first exception
        try {
            throw new JarException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions6() {   //it's first exception
        try {
            throw new KeyException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions7() {   //it's first exception
        try {
            throw new EmptyStackException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions8() {   //it's first exception
        try {
            throw new UTFDataFormatException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }private static void initExceptions9() {   //it's first exception
        try {
            throw new LambdaConversionException();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
