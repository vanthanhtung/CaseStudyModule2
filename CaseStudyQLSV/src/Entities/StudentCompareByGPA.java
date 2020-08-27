package Entities;

import java.util.Comparator;

public class StudentCompareByGPA implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getGPA(),o1.getGPA());
    }
}
