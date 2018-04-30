package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double i;
        double count = 0.0;
        double sum = 0.0;
        while(true){
            i = Integer.parseInt(reader.readLine());
            if (i == -1){
                double result = sum/count;
                System.out.println(result);
                break;
            }
                double result = sum/count;

            count++;
            sum += i;
        }


    }
}

