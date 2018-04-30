package com.javarush.task.task15.task1525;

import org.omg.CORBA.portable.InputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по-отдельности в List lines.
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            Files.lines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
