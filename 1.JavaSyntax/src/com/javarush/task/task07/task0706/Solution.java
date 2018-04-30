package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
1. Создать массив на 15 целых чисел.
2. Ввести в него значения с клавиатуры.
3. Пускай индекс элемента массива является номером дома, а значение — число жителей, проживающих в доме.
Дома с нечетными номерами расположены на одной стороне улицы, с четными — на другой.
Выяснить, на какой стороне улицы проживает больше жителей.
4. Вывеси на экран сообщение: «В домах с нечетными номерами проживает больше жителей.»
или «В домах с четными номерами проживает больше жителей.»

Примечание:
дом с порядковым номером 0 считать четным.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] mass = new int[15];
        int even = 0;
        int odd = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mass.length; i++){
            mass[i] = Integer.parseInt(reader.readLine());//напишите тут ваш код
        }
        for (int i = 0; i < mass.length; i+=2)
            even += mass[i];
        for (int i = 1; i < mass.length; i+=2){
            odd += mass[i];
        }
        if (even > odd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
