package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String laters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuilder pass = new StringBuilder();

        for (int i=0; i<3; i++) {
            pass.append(laters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<3; i++) {
            pass.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<2; i++) {
            pass.append(laters.toUpperCase().charAt((int)(Math.random()*26)));
        }

        try {
            output.write(pass.toString().getBytes());
        } catch (Exception ignored)
        {

        }

        return output;
    }

}