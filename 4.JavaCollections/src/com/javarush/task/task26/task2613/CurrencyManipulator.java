package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
            return;
        }
        denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int totalSum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            totalSum += pair.getKey() * pair.getValue();
        }
        return totalSum;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        if (getTotalAmount() < expectedAmount)
            throw new NotEnoughMoneyException();
        List<Integer> nominals = new ArrayList<>(denominations.keySet());
        nominals.sort(Comparator.reverseOrder());
        Map<Integer, Integer> copy = new TreeMap<>(Comparator.reverseOrder());
        copy.putAll(denominations);
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nominals.size(); ) {
            int banknote = nominals.get(i);
            if (banknote <= expectedAmount && copy.containsKey(banknote) && copy.get(banknote) > 0) {
                result.merge(banknote, 1, (i1, i2) -> i1 + i2);
                copy.merge(banknote, -1, (i1, i2) -> i1 + i2);
                expectedAmount -= banknote;
            } else i++;
            if (copy.containsKey(banknote) && copy.get(banknote) == 0) {
                copy.remove(banknote);
            }
        }
        if (expectedAmount > 0)
            throw new NotEnoughMoneyException();
        denominations.clear();
        denominations.putAll(copy);
        return result;
    }
}

