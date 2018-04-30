package com.javarush.task.task14.task1420;

/* 
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a<=0) throw new Exception();
            if (b<=0) throw new Exception();
            printWriter.println(gcd(a, b));
            scanner.close();
            printWriter.close();
          }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
