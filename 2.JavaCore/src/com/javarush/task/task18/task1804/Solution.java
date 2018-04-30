package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream (reader.readLine());
        //FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> hashmap = new HashMap<>();
        while (inputStream.available() > 0) {
            int d = inputStream.read();
            if(hashmap.containsKey(d)) {
                hashmap.put(d,hashmap.get(d) + 1);
            } else hashmap.put(d, 1);
        }
        int max = 9999999;
        for(Map.Entry entry: hashmap.entrySet()) {
            if ((int) entry.getValue() < max) max = (int) entry.getValue();
        } for (Map.Entry entry: hashmap.entrySet()) {
            if(entry.getValue().equals(max)) System.out.print(entry.getKey() + " ");
        }
        reader.close();
        inputStream.close();
    }
}
