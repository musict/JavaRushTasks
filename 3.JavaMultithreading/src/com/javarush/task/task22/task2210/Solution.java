package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        int i = 0;
        StringTokenizer tokin = new StringTokenizer(query, delimiter);
        String[] list = new String[tokin.countTokens()];
        while(tokin.hasMoreTokens()){
            list[i] = tokin.nextToken();
            i++;
        }
        return list;
//        String[] strings = new String[1000];
//        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
//        for (int i = 0; i < 1000; i++){
//            if (tokenizer.hasMoreTokens()){
//                strings[i] = '"' + tokenizer.nextToken() + '"';
//            }
//
//        }
//        return strings;
    }
}
