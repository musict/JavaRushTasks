package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException{
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
//        writeMessage("Список блюд:");
        writeMessage(Dish.allDishesToString());
        List<Dish> dishList = new LinkedList<>();

        boolean choosing = true;
        while(true) {
            start:
            {
//                writeMessage("Введите название блюда и нажмите Enter");
//                writeMessage("Если вы закончили, введите \"exit\"");

                String dish = readString().toLowerCase();
                if (dish.equals("exit")) break;
                for (Dish d : Dish.values()) {
                    if (dish.equals(d.name().toLowerCase())) {
                        dishList.add(d);
                        break start;
                    }
                }
                writeMessage("Такого блюда нет в меню.");
            }
        }
        return dishList;
    }
    public static List<Dish> getAllDishesForOrderTest() throws IOException {
//        writeMessage("Список блюд:");
        writeMessage(Dish.allDishesToString());
        List<Dish> dishList = new LinkedList<>();

        dishList.add(Dish.Fish);

        return dishList;
    }
}
