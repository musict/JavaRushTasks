package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        long start = System.currentTimeMillis();
        for (String value : strings) {
            ids.add(shortener.getId(value));
        }
        return System.currentTimeMillis() - start;
    }
    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        long start = System.currentTimeMillis();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        return System.currentTimeMillis() - start;
    }
    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> origIds = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        long testTimeForIdShortener1 = getTimeForGettingIds(shortener1, origStrings, origIds);
        long testTimeForIdShortener2 = getTimeForGettingIds(shortener2, origStrings, origIds);

        Assert.assertTrue(testTimeForIdShortener1 > testTimeForIdShortener2);

        long testTimeForStringsShortener1 = getTimeForGettingStrings(shortener1, origIds, origStrings);
        long testTimeForStringsShortener2 = getTimeForGettingStrings(shortener2, origIds, origStrings);

        Assert.assertEquals(testTimeForStringsShortener1, testTimeForStringsShortener2, 30);
    }
}
