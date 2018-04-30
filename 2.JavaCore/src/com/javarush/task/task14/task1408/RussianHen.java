package com.javarush.task.task14.task1408;

/**
 * Created by Python on 15.03.2017.
 */
public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 4;
    }
    String getDescription(){
        return (super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
