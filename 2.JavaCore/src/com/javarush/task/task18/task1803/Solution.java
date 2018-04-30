package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        Integer am;
        Integer max = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < fileInputStream.available(); i++){
            list.add(fileInputStream.read());
        }

        for (Integer i : list) {
            am = hm.get(i);
            hm.put(i, am == null ? 1 : am + 1);
        }

        for (Map.Entry<Integer, Integer> pair : hm.entrySet()){
            if (pair.getValue() > max) max =  pair.getValue();
        }

        for (Map.Entry<Integer, Integer> pair : hm.entrySet()){
            if (pair.getValue().equals(max)) System.out.print(pair.getKey() + " ");
        }

        fileInputStream.close();
    }
}
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
        int max = 0;
        for(Map.Entry entry: hashmap.entrySet()) {
            if ((int) entry.getValue() > max) max = (int) entry.getValue();
        } for (Map.Entry entry: hashmap.entrySet()) {
            if(entry.getValue().equals(max)) System.out.print(entry.getKey() + " ");
        }
        reader.close();
        inputStream.close();
    }
}
