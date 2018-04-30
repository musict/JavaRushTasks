package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        FileInputStream fileInputStream1 = new FileInputStream(fileName2);
        FileInputStream fileInputStream2 = new FileInputStream(fileName3);

        while (fileInputStream1.available() > 0){
            int data = fileInputStream1.read();
            fileOutputStream.write(data);
        }
        while (fileInputStream2.available() > 0){
            int data = fileInputStream2.read();
            fileOutputStream.write(data);
        }

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();

    }
}
