package com.javarush.task.task20.task2002;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("test1");
            user.setLastName("test2");
            user.setMale(false);
            user.setCountry(User.Country.RUSSIA);
            user.setBirthDate(new Date());
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            if (users.isEmpty()) {
                writer.write("empty");
            } else {
                for (User user : users) {
                    writer.print(user.getFirstName() + ":");
                    writer.print(user.getLastName() + ":");
                    writer.print(user.isMale() + ":");
                    writer.print(user.getBirthDate() == null ? null : user.getBirthDate().getTime());
                    writer.print(":");
                    writer.println(user.getCountry() == null ? null : user.getCountry().getDisplayedName());
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//			String line = reader.readLine();
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.equals("empty")) {
                    break;
                }
                String[] partsUser = line.split(":");
                User user = new User();
                if (partsUser[0].equals("null")) {
                    user.setFirstName(null);
                } else {
                    user.setFirstName(partsUser[0]);
                }
                if (partsUser[1].equals("null")) {
                    user.setLastName(null);
                } else {
                    user.setLastName(partsUser[1]);
                }
                user.setMale(Boolean.parseBoolean(partsUser[2]));
                if (partsUser[3].equals("null")) {
                    user.setBirthDate(null);
                } else {
                    user.setBirthDate(new Date(Long.parseLong(partsUser[3])));
                }
                if (partsUser[4].equals("Ukraine")) {
                    user.setCountry(User.Country.UKRAINE);
                } else if (partsUser[4].equals("Russia")) {
                    user.setCountry(User.Country.RUSSIA);
                } else if (partsUser[4].equals("Other")) {
                    user.setCountry(User.Country.OTHER);
                } else {
                    user.setCountry(null);
                }
                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
