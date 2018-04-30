package com.javarush.task.task14.task1408;

/**
 * Created by Python on 15.03.2017.
 */
public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }
    String getDescription(){
        return (super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
