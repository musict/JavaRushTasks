package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
Измени класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для ATableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели.
Метод getHeaderText должен возвращать текст в верхнем регистре — используйте метод toUpperCase().


Требования:
1. Класс TableInterfaceWrapper должен реализовывать интерфейс ATableInterface.
2. Класс TableInterfaceWrapper должен инициализировать в конструкторе поле типа ATableInterface.
3. Метод setModel() должен вывести в консоль количество элементов в новом листе перед обновлением модели.
4. Метод getHeaderText() должен возвращать текст в верхнем регистре.
5. Метод setHeaderText() должен устанавливать текст для заголовка без изменений.
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        private ATableInterface aTableInterface;
        public TableInterfaceWrapper(ATableInterface aTableInterface1){
            this.aTableInterface = aTableInterface1;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            aTableInterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return aTableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            aTableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}