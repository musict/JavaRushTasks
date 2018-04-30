package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id — 8 символов
productName — название товара, 30 chars (60 bytes)
price — цена, 8 символов
quantity — количество, 4 символа
-u — обновляет данные товара с заданным id
-d — производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //C:\123.txt
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader2.readLine();
        reader2.close();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        reader.close();
        for (int i = 0; i < list.size(); i++) {
            String currentId = list.get(i).substring(0, 8).trim();
            if (args[1].equals(currentId)) {
                if (args[0].equals("-u")) {
                    String price = args[3];
                    String quantity = args[4];
                    StringBuilder productName = new StringBuilder();
                    productName.append(args[2]);
                    for (int j = 3; j < args.length - 2; j++) productName.append(" " + args[j]);
                    String result = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", args[1], productName, price, quantity);
                    list.set(i, result);
                }
                if (args[0].equals("-d")) {
                    list.remove(i);
                }
                i = list.size();
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int j = 0; j < list.size(); j++) {
            writer.write(list.get(j));
            if (j < list.size() - 1)
                writer.write(System.lineSeparator());
        }
        writer.close();
    }
}