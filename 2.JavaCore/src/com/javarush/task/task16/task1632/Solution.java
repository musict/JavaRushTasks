package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/*Клубок
        1. Создай 5 различных своих нитей c отличным от Thread типом:
        1.1. Нить 1 должна бесконечно выполняться;
        1.2. Нить 2 должна выводить «InterruptedException» при возникновении исключения InterruptedException;
        1.3. Нить 3 должна каждые полсекунды выводить «Ура«;
        1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
        1.5. Нить 5 должна читать с консоли числа пока не введено слово «N«, а потом вывести в консоль сумму введенных чисел.
        2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
        3. Нити не должны стартовать автоматически.

        Подсказка:
        Нить 4 можно проверить методом isAlive()


        Требования:
        1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
        2. Нити из списка threads не должны стартовать автоматически.
        3. Нить 1 из списка threads должна бесконечно выполняться.
        4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
        5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
        6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
        7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
*/
public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {

    }
    public static class Thread1 extends Thread{
        public void run() {
            while (true)
            {
            }
        }
    }
    public static class Thread2 extends Thread  {
        @Override
        public void run() {
            try {
                sleep(5000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread {
        public void run() {
            try
            {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            }
            catch (InterruptedException e)
            {
            }
        }
    }
    public static class Thread4 extends Thread implements Message{

            @Override
            public void run() {
                while (!isInterrupted()) {}
            }

            @Override
            public void showWarning() {
                interrupt();
            }
        }


    public static class Thread5 extends Thread  {
        public void run() {
            try {
                ArrayList<Integer> array = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (!isInterrupted()){
                    String read = reader.readLine();
                    if (read.equals("N")){
                        int sum=0;
                        for (int i=0; i<array.size(); i++){
                            sum+=array.get(i);
                        }
                        System.out.println(sum);
                    } else {
                        array.add(Integer.parseInt(read));
                    }
                }
            } catch (IOException e){}
        }
    }
    }

