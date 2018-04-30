package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String filename = scn.nextLine();

        int k1 = 0;
        int k2 = 0;

        FileInputStream fileInputStream = new FileInputStream(filename);
        while (fileInputStream.available() > 0){
            k1 = fileInputStream.read();
            if (k2 < k1) k1 = k2;
        }
        fileInputStream.close();
        System.out.println(k2);

    }
}
