package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.DualHashBidiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;
import com.javarush.task.task33.task3310.tests.FunctionalTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> idSet = new HashSet<>();
        for (String value : strings) {
            idSet.add(shortener.getId(value));
        }
        return idSet;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> valuesSet = new HashSet<>();
        for (Long id : keys) {
            valuesSet.add(shortener.getString(id));
        }
        return valuesSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testValuesSet = new HashSet<>();
        Set<Long> testKeysSet = new HashSet<>();
        Set<String> testResult = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testValuesSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date start = new Date();
        for (String value : testValuesSet) {
            testKeysSet.add(shortener.getId(value));
        }
        Date stop = new Date();
        Helper.printMessage(Long.toString(stop.getTime() - start.getTime()));
        start = new Date();
        for (Long key : testKeysSet) {
            testResult.add(shortener.getString(key));
        }
        stop = new Date();
        Helper.printMessage(Long.toString(stop.getTime() - start.getTime()));
        if (testValuesSet.equals(testResult)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }


    }

    public static void main(String[] args) {

        FunctionalTest test = new FunctionalTest();
        test.testHashBiMapStorageStrategy();

//        StorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
//        testStrategy(hashMapStorageStrategy, 10000);
//
//        StorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
//        testStrategy(dualHashBidiMapStorageStrategy, 1000);
//
//        StorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
//        testStrategy(hashBiMapStorageStrategy, 1000);

    }
}
