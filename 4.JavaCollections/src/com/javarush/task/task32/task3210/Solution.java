package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try ( RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            byte[] buffer = new byte[text.length()];
            raf.seek(number);
            long length = 0;
            if ( (length = (raf.length() - number)) > buffer.length ) {
                raf.read(buffer, 0, buffer.length);
            } else {
                raf.read(buffer, 0, (int) length);
            }
            raf.seek(raf.length());
            if (text.equals(convertByteToString(buffer))){
                raf.write("true".getBytes());
            }else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
        }
    }

    public static String convertByteToString(byte[] readBytes){
        return new String(readBytes);
    }
}