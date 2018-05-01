package com.javarush.task.task36.task3605;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while(reader.ready()){
                String s = reader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]","");
                for (int i = 0; i < s.length(); i++){
                    set.add(s.charAt(i));
                }
            }
        }
        int n = set.size() < 5 ? set.size() : 5;
        Iterator iterator = set.iterator();
        for (int i = 0; i < n; i++) {
            System.out.print(iterator.next());

        }
    }
}
