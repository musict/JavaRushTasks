package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь конструктор с параметром int — количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен «helicopter«, то статическому объекту Flyable result присвоить объект класса Helicopter.
3.3. Если параметр равен «plane«, то считать второй параметр типа int(количество пассажиров),
 статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
5. Закрыть поток ввода методом close().
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();//add your code here - добавьте код тут
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("helicopter")) result = new Helicopter();
        if (s.equals("plane")) {
            int i = Integer.parseInt(reader.readLine());
            result = new Plane(i);//add your code here - добавьте код тут
        }
        reader.close();
    }
}
