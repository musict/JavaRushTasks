package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class <T> tClass;
    T newInstance() {
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Generator(Class<T> tClass) {
        this.tClass = tClass;
    }
}
