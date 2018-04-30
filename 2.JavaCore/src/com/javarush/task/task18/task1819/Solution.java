package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        FileInputStream fileInputStream1 = new FileInputStream(fileName2);
        byte[] bt1 = new byte[fileInputStream.available()];
        byte[] bt2 = new byte[fileInputStream1.available()];
        fileInputStream.read(bt1);
        fileInputStream1.read(bt2);
        fileOutputStream.write(bt2);
        fileOutputStream.write(bt1);
        fileInputStream.close();
        fileInputStream1.close();
        fileOutputStream.close();


    }
}
