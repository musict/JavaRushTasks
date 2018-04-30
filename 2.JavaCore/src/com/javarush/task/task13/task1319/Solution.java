package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Запись в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        String str;
        do  {
            str = reader.readLine();
            writer.write(str);
            writer.newLine();
        } while (!str.equals("exit"));
        writer.close();
        reader.close();
    }
}