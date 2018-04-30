package com.javarush.task.task28.task2805;

import javafx.scene.layout.Priority;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    private int increment(){
        int getAtomicInteger = atomicInteger.get();
        if (getAtomicInteger == MAX_PRIORITY){
            atomicInteger.set(1);
            return 1;
        }
        else if (getAtomicInteger > Thread.currentThread().getThreadGroup().getMaxPriority()){
            atomicInteger.set(Thread.currentThread().getThreadGroup().getMaxPriority());
        } else {
            getAtomicInteger = atomicInteger.incrementAndGet();
        }
        return getAtomicInteger;

    }

    public MyThread() {
        super();
        this.setPriority(increment());
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(increment());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(increment());
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(increment());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(increment());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(increment());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(increment());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(increment());
    }
}

