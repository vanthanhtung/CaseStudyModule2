package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Serializable {
    private int ID;
    private String name;
    private String gender;
    private int age;
    private ArrayList<Mark> markList;

    public Student() {
    }

    public Student(int ID, String name, String gender,
                   int age, ArrayList<Mark> markList)
    {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.markList = markList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(ArrayList<Mark> markList) {
        this.markList = markList;
    }

    public double getGPA() {
        double sum =0;
        for (Mark x: markList) {
            sum += x.getValue();
        }
        return sum/markList.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", GPA=" + getGPA() +
                '}';
    }
}
