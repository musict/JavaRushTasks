package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 — 3
3.50 — 4
3.51 — 4
-3.49 — -3
-3.50 — -3
-3.51 — -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = cin.readLine();
        String filename2 = cin.readLine();
        FileInputStream fin = new FileInputStream(filename1);
        FileOutputStream fout = new FileOutputStream(filename2);
        StringBuilder str = new StringBuilder();
        while (fin.available() > 0) {
            str.append(Character.toChars(fin.read()));
        }
        String[] numbers = str.toString().split(" ");

        for (int i = 0; i < numbers.length; i++) {
            int digit = Math.round(Float.parseFloat(numbers[i]));
            fout.write(Integer.toString(digit).getBytes());
            fout.write(32);
        }
        fin.close();
        fout.close();
    }
}
