package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
       ConsoleHelper.writeMessage(res.getString("before"));
       String code = ConsoleHelper.askCurrencyCode();
        String[] currencyCount = new String[0];
        int cur = 0;
        int count = 0;
        try {
            currencyCount = ConsoleHelper.getValidTwoDigits(code);
            cur = Integer.parseInt(currencyCount[0]);
            count = Integer.parseInt(currencyCount[1]);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
       currencyManipulator.addAmount(Integer.parseInt(currencyCount[0]), Integer.parseInt(currencyCount[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cur * count, code));
    }
}
