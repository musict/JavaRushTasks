package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    private static int folders = 0;
    private static int files = 0;
    private static long size = 0;

    public static void main(String[] args) throws IOException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Path path = Paths.get(fileName);
        if (!Files.isDirectory(path) || path == null){
            System.out.println(path.toString() + " - не папка");
            return;
        }

        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                files++;
                size += Files.size(file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                folders++;
                return super.preVisitDirectory(dir, attrs);
            }
        });
        System.out.println("Всего папок - " + (folders -1));
        System.out.println("Всего файлов - " + files);
        System.out.println("Общий размер - " + size);
    }
}
