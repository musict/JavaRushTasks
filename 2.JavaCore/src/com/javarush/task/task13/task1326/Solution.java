package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// напишите тут ваш код
        String source = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        Scanner inputStream = new Scanner(new FileInputStream(source));
        while (inputStream.hasNext()) {
            int data = inputStream.nextInt();
            if (data % 2 == 0)
                list.add(data);
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
        inputStream.close();
        reader.close();
    }
}
