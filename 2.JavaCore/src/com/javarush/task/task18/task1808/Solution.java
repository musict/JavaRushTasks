package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);
        byte[] buffer = new byte[file1.available()];
        file1.read(buffer);
        file3.write(buffer, (int)(buffer.length / 2) + (buffer.length % 2), (int)(buffer.length / 2));
        file2.write(buffer, 0, (int)(buffer.length / 2) + (buffer.length % 2));
        file1.close();
        file2.close();
        file3.close();
        reader.close();


    }
}
