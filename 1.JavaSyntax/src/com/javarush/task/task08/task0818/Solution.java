package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1000);//напишите тут ваш код
        map.put("b", 1000);//напишите тут ваш код
        map.put("c", 1000);//напишите тут ваш код
        map.put("d", 1000);//напишите тут ваш код
        map.put("e", 1000);//напишите тут ваш код
        map.put("f", 1000);//напишите тут ваш код
        map.put("g", 1000);//напишите тут ваш код
        map.put("h", 1000);//напишите тут ваш код
        map.put("k", 499);//напишите тут ваш код
        map.put("l", 499);

        return map;//напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet() ){
            if (pair.getValue() < 500) map.remove(pair.getKey());
        }

    }

    public static void main(String[] args) {

    }
}