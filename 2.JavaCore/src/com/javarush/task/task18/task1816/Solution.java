package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabetL = "abcdefghijklmnopqrstuvwxyz";
        String alphabetH = alphabetL.toUpperCase();

        FileReader f = new FileReader(args[0]);

        int count = 0;
        while (f.ready()) {
            char s = (char) f.read();
            if ((alphabetL.indexOf(s) > -1) || alphabetH.indexOf(s) > -1)
                count++;
        }
        f.close();

        System.out.println(count);

    }
}