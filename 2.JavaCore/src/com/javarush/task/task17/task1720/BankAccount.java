package com.javarush.task.task17.task1720;
/*
Банкомат
Разберись, как работает программа

Во время тестирования лог содержит следующее:
…..
Добавляем 100, на счету 1100
Добавляем 100, на счету 1200
Тратим 1000, на счету 100
Недостаточно денег
…..

Создан баг:
При списании денег со счета теряются деньги

Найти и исправить ошибку


Требования:
1. Класс BankAccount должен содержать private поле balance типа BigDecimal.
2. Метод deposit(String money) класса BankAccount должен делегировать поведение в метод deposit(BigDecimal money).
3. Метод withdraw(String money) класса BankAccount должен делегировать поведение в метод withdraw(BigDecimal money).
4. В методе withdraw(BigDecimal money), если необходимо, используй synchronized.
5. В методе deposit(BigDecimal money), если необходимо, используй synchronized.
 */

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;
    private String owner;

    public BankAccount(String owner) {
        this(BigDecimal.ZERO, owner);
    }

    public BankAccount(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized void deposit(BigDecimal money) {
        BigDecimal newBalance = balance.add(money);
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        balance = newBalance;
    }

    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {
        BigDecimal newBalance = balance.subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

        balance = newBalance;
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}
