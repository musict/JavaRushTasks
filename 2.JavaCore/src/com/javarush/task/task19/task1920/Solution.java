package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    static TreeMap<String, Double> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        String filename = args[0];

        BufferedReader file = new BufferedReader(new FileReader(filename));
        double max = Double.MIN_VALUE;

        while (file.ready()) {
            String s = file.readLine();
            String[] strs = s.split(" ");
            addMap(strs[0], Double.parseDouble(strs[1]));
        }

        file.close();


        for (Double a : map.values())
            if (max < a)
                max = a;

        for (Map.Entry<String, Double> pair : map.entrySet())
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());

    }


    private static void addMap(String name, Double value) {
        if (!map.containsKey(name))
            map.put(name,value);
        else
            map.put(name, map.get(name) + value);
    }
}