package com.javarush.task.task35.task3507;

import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        //C:\Users\Python\Downloads\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task35\task3507\data
        return null;
    }
}
