package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader filename = new FileReader(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while(filename.ready()){
            stringBuilder.append((char) filename.read());
        }
        String s = stringBuilder.toString();
        String[] parts = s.split("[^A-Za-z0-9]");
        for (int i = 0; i < parts.length; i++){
            if (parts[i].equals("world")){
                count++;
            }
        }
        System.out.println(count);
        reader.close();
        filename.close();

    }
}
