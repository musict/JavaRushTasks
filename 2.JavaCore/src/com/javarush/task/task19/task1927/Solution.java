package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: «JavaRush — курсы Java онлайн»

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строки: "first","second","third","fourth","fifth".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строки(вставлять контекстную рекламу)
 выведенные методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new MyStream(new PrintStream(outputStream));//создаем Декоратор
        System.setOut(stream);

        testString.printSomething();
        System.setOut(consoleStream); //Возвращаем как было

        System.out.println(outputStream.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    //Все остальные методы, кроме переопределенных будут работать, как и в обычном PrintStream
    public static class MyStream extends PrintStream {
        private static int count = 0;
        private String adv = "\r\nJavaRush - курсы Java онлайн";

        private PrintStream printStream;

        MyStream (PrintStream printStream) {
            super(printStream);
            this.printStream = printStream;
        }

        @Override
        public void print(String s) {
            if (MyStream.count == 1) {
                printStream.print(s+adv);
                MyStream.count = 0;
            } else {
                printStream.print(s);
                MyStream.count++;
            }
        }

        public MyStream(OutputStream out) {
            super(out);
        }
    }
}