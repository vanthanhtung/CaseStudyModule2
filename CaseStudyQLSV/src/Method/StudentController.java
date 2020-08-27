package Method;

import Entities.Mark;
import Entities.Student;
import Entities.StudentCompareByGPA;
import Entities.StudentCompareByName;
import IOFile.IOFile;
import Service.IStudent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentController implements IStudent {
    Scanner scanner = new Scanner(System.in);
    public static List<Student> studentList = new ArrayList<>();


    public StudentController(){
    }
//    static {
//        ArrayList<Mark> m1 = new ArrayList<>();
//        m1.add(new Mark("English",5.5));
//        m1.add(new Mark("Math",6.6));
//        m1.add(new Mark("Science",7.4));
//        Student student1 = new Student(1,"Tung","nam",25, m1);
//
//        ArrayList<Mark> m2 = new ArrayList<>();
//        m2.add(new Mark("English",7.7));
//        m2.add(new Mark("Math",6.5));
//        m2.add(new Mark("Science",8.7));
//        Student student2 = new Student(2,"Hung","nam",24, m2);
//
//        ArrayList<Mark> m3 = new ArrayList<>();
//        m3.add(new Mark("Science",9.0));
//        m3.add(new Mark("Math",6.9));
//        m3.add(new Mark("Science",8.1));
//        Student student3 = new Student(3,"Dung","nam",26, m3);
//
//        studentList.add(student1); studentList.add(student2); studentList.add(student3);
//    }

    public void add(){
        Student student1 = new Student();

        System.out.println("Add name");
        String name1 = scanner.nextLine();
        student1.setName(name1);
        int id1;
        do{
            try{
                System.out.println("Input ID");
                id1 = Integer.parseInt(scanner.nextLine());
                boolean isExist = false;
                for (Student m: studentList) {
                    if (m.getID()==id1) {
                        System.out.println("This ID has been used! Input another");
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) break;
            }
            catch (Exception e) {
                System.out.println("Input again! ID must be int");
            }
        } while (true);
        student1.setID(id1);

        try{
            System.out.println("Age?");
            int age1 =Integer.parseInt(scanner.nextLine());
            student1.setAge(age1);
        }
        catch (Exception e){
            System.out.println("Input again!");
            add();
        }

        System.out.println("Male/Female?");
        String sex1 = scanner.nextLine();
        student1.setGender(sex1);

        ArrayList<Mark> markList = new ArrayList<>();
        Mark mark1 = new Mark("English");
        System.out.println("Input mark of "+ mark1.getSubjectName());
        mark1.setValue(Double.parseDouble(scanner.nextLine()));
        markList.add(mark1);

        Mark mark2 = new Mark("Math");
        System.out.println("Input mark of "+ mark2.getSubjectName());
        mark2.setValue(Double.parseDouble(scanner.nextLine()));
        markList.add(mark2);

        Mark mark3 = new Mark("Science");
        System.out.println("Input mark of "+ mark3.getSubjectName());
        mark3.setValue(Double.parseDouble(scanner.nextLine()));
        markList.add(mark3);

        student1.setMarkList(markList);
        studentList.add(student1);
        System.out.println(student1.getName()+" was added!");
    }

    public Student remove(){
        System.out.println("Input ID of student that you want to remove");
        int removeID = scanner.nextInt();
        for (Student x: studentList) {
            if (x.getID()== removeID) {
                studentList.remove(x);
                System.out.println("Student "+x.getName()+" with ID="+x.getID()+" was removed from Student-List");
                return x;
            }
        }
        System.out.println("There is NO student with this ID in the List");
        return null;
    }

    public void edit(){
        try{
            System.out.println("Input Student's ID");
            int editID =Integer.parseInt(scanner.nextLine());
            for (Student x: studentList) {
                if (x.getID()== editID) {
                    System.out.println(x.toString());

                    System.out.println("Input new age");
                    int age2 =Integer.parseInt(scanner.nextLine());
                    x.setAge(age2);

                    System.out.println("Input new gender");
                    String sex2 = scanner.nextLine();
                    x.setGender(sex2);

                    for (Mark y: x.getMarkList()) {
                        System.out.println("in put new mark of "+y.getSubjectName());
                        y.setValue(Double.parseDouble(scanner.nextLine()));
                    }
                    return;
                }
            }
            System.out.println("There is NO student with this ID in the List");
        }
        catch (Exception e){
            System.out.println("Input again! ID must be int");
        }
    }

    public void search(){
        System.out.println("Input name of student");
        String searchName = scanner.nextLine();

        for (Student x: studentList) {
            if (x.getName().equals(searchName)){
                System.out.println(x.toString());
                return;
            }
        }
        System.out.println("This student is not in the list");
    }

    public void ShowListSortedByName(){
        studentList.sort(new StudentCompareByName());
        for (Student s: studentList) {
            System.out.println(s);
        }
    }

    public void ShowListSortedByGPA(){
        studentList.sort(new StudentCompareByGPA());
        for (Student s: studentList) {
            System.out.println(s);
        }
    }

    public void saveStudentListToFile() throws IOException {
        System.out.println("Input File Path");
        IOFile.WriteFile((ArrayList<Student>) studentList,scanner.nextLine());
        System.out.println("Saved!");
    }
    @Override
    public void display() {

    }
}
