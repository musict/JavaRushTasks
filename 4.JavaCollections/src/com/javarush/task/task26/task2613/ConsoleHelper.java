package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
    static private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = "";
        try {
            line = bis.readLine();
            if (line.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String currencyCode = readString();
            if (currencyCode == null) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (currencyCode.length() != 3) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            return currencyCode.toUpperCase();

        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            int nominal = 0;
            int count = 0;
            String[] strings;
            try {
                strings = readString().split(" ");
                nominal = Integer.parseInt(strings[0]);
                count = Integer.parseInt(strings[1]);
                if (nominal <= 0 || count <= 0) {
                    writeMessage(res.getString("invalid.data"));
                    continue;
                }
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            return strings;

        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO"));
            writeMessage("2 - " + res.getString("operation.DEPOSIT"));
            writeMessage("3 - " + res.getString("operation.WITHDRAW"));
            writeMessage("4 - " + res.getString("operation.EXIT"));
            int number = 0;
            try {
                number = Integer.parseInt(readString());
                if (number < 1 || number > 4) {
                    writeMessage(res.getString("invalid.data"));
                    continue;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return Operation.getAllowableOperationByOrdinal(number);

        }
    }
}
