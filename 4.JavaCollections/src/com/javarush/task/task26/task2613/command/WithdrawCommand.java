package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.security.Provider;
import java.util.Comparator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        Map<Integer, Integer> money = new TreeMap<>(Comparator.reverseOrder());
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            int expectedMoney;
            try {
                expectedMoney = Integer.parseInt(ConsoleHelper.readString());
                if (manipulator.isAmountAvailable(expectedMoney)) {
                    money.putAll(manipulator.withdrawAmount(expectedMoney));
                    for (Map.Entry<Integer, Integer> pair : money.entrySet()) {
                        ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), expectedMoney, currencyCode));
                    break;
                }
                else throw new NotEnoughMoneyException();
            }
            catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
        }
    }
}
