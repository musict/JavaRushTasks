package com.javarush.task.task31.task3105;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        String fileName = args[1];
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileName));
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(path.toString()));
    }
}
