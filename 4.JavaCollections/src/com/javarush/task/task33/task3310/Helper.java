package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {



    public static String generateRandomString(){
        BigInteger bInt = new BigInteger(130,  new SecureRandom());
        return bInt.toString(32);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
