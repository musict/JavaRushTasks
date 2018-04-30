package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if (reader == null){
            return stringWriter.toString();
        }
        BufferedReader br = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){

            char[] chars = line.toCharArray();
            for (char c : chars) {
                char tmp = (char) (c + key);
                stringBuilder.append(tmp);
            }
        }
        stringWriter.write(stringBuilder.toString());
        return stringWriter.toString();

    }
}
