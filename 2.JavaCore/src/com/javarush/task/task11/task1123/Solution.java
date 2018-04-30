package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    private static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }


        else {
            int x = array[0];
            int y = array[0];

            for(int i = 0; i < array.length; i++){
                if (array[i]<x) x = array[i];
                if (array[i]>y) y = array[i];//Напишите тут ваше решение
            }
            return new Pair<Integer, Integer>(x,y);

        }


    }


    private static class Pair<X, Y> {
        private X x;
        private Y y;

        private Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
