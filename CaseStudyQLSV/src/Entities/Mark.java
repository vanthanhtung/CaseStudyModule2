package Entities;

import java.io.Serializable;

public class Mark implements Serializable {
    private String subjectName;
    private double value;
    public Mark(){}
    public Mark(String subjectName){
        this.subjectName =subjectName;
    }

    public Mark(String subjectName, double value) {
        this.subjectName = subjectName;
        this.value = value;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
