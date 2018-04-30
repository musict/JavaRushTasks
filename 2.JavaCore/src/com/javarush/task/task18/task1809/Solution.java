package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream outputStream = new FileOutputStream(s2);

        ArrayList<Integer> list = new ArrayList<>();

        while(inputStream.available() > 0){
            int count = inputStream.read();
            list.add(count);
        }

        for (int i = list.size() - 1; i >= 0; i--){
            outputStream.write(list.get(i));
        }

        reader.close();
        inputStream.close();
        outputStream.close();

    }
}