package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try ( RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            if (text.length() + number > raf.length()) {
                raf.seek(raf.length());
                raf.write(text.getBytes());
            }else {
                raf.seek(number);
                raf.write(text.getBytes());
            }
        } catch (IOException e) {
        }

    }
}
