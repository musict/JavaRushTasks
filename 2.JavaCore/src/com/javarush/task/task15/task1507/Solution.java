package com.javarush.task.task15.task1507;

/* 
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }

    }
    public static void printMatrix(int m){

    }
    public static void printMatrix(int m, int n){

    }
    public static void printMatrix(int m, Object value){

    }
    public static void printMatrix(int m, String value){

    }
    public static void printMatrix(String value){

    }
    public static void printMatrix(Object value){

    }
    public static void printMatrix(String value, int n){

    }
    public static void printMatrix(Object value, int n){

    }
}
