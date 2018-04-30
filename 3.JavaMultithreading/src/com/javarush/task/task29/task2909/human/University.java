package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University  {
    private List<Student> students = new ArrayList<Student>();
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public University(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students)
        {
            if (student.getAverageGrade() == averageGrade)
                return student;//TODO:
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Double maxAVG = 0.0;
        Student student = null;
        for (Student s : students) {
            if (s.getAverageGrade() > maxAVG){
                maxAVG = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Double maxAVG = 100.0;
        Student student = null;
        for (Student s : students) {
            if (s.getAverageGrade() < maxAVG){
                maxAVG = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }
    public void expel(Student student){
        students.remove(student);
    }
}