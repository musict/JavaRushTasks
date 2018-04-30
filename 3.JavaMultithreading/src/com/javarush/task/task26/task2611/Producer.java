package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;
    private int count = 1;
    public Producer(ConcurrentHashMap map){
        this.map = map;
    }
    @Override
    public void run() {
        try {
            while (true) {

                map.put(String.valueOf(count), "Some text for " + count++);
                Thread.sleep(500);

            }
        } catch (Exception e){
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}
