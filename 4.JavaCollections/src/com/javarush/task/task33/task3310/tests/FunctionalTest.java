package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;


public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String firstString = "firstString";
        String secondString = "secondString";
        String thirdString = "firstString";

        long idFirstString = shortener.getId(firstString);
        long idSecondString = shortener.getId(secondString);
        long idThirdString = shortener.getId(thirdString);

        Assert.assertNotEquals(idFirstString, idSecondString);
        Assert.assertEquals(idFirstString, idThirdString);

        String testFirstString = shortener.getString(idFirstString);
        String testSecondString = shortener.getString(idSecondString);
        String testThirdString = shortener.getString(idThirdString);

        Assert.assertEquals(firstString, testFirstString);
        Assert.assertEquals(secondString, testSecondString);
        Assert.assertEquals(thirdString, testThirdString);

    }

    @Test
    public void testHashMapStorageStrategy(){
        StorageStrategy storageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        StorageStrategy storageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        StorageStrategy storageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        StorageStrategy storageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        StorageStrategy storageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        StorageStrategy storageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }
}
