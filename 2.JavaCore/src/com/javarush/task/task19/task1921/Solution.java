package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (reader.ready()){
            String line = reader.readLine();
            String namePart = line.replaceAll("[\\w]", "").trim();
            String[] digitalPart = line.substring(namePart.length()).trim().split(" ");
            int day = Integer.parseInt(digitalPart[0]);
            int month = Integer.parseInt(digitalPart[1]);
            int year = Integer.parseInt(digitalPart[2]);
            Date date = new GregorianCalendar(year, month -1, day).getTime();
            PEOPLE.add(new Person(namePart, date));

        }
        reader.close();
    }
}
