package View;

import Entities.Student;
import IOFile.IOFile;
import Method.StudentController;
import Method.MarkController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            StudentController.studentList = IOFile.ReadFile("danhsach.txt");
        } catch (Exception e) {
            StudentController.studentList = new ArrayList<>();
        }
        StudentController studentController = new StudentController();
        MarkController markController = new MarkController();

        startApp:
        do {
            System.out.println("=====================================================================");
            System.out.println("1: Add student");
            System.out.println("2: Remove student");
            System.out.println("3: Edit information");
            System.out.println("4: Search student");
            System.out.println("5. Show Student-List sorted by name");
            System.out.println("6. Show Student-List sorted by GPA");
            System.out.println("7. Save Student-List to file");
            System.out.println("0: Exit");
            System.out.println("=====================================================================");
            int choice2 = Integer.parseInt(input.nextLine());
            switch (choice2) {
                case 1:
                    studentController.add();
                    break;
                case 2:
                    studentController.remove();
                    break;
                case 3:
                    studentController.edit();
                    break;
                case 4:
                    studentController.search();
                    break;
                case 5:
                    studentController.ShowListSortedByName();
                    break;
                case 6:
                    studentController.ShowListSortedByGPA();
                    break;
                case 7:
                    try {
                        studentController.saveStudentListToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0: System.exit(0);
                    break;
                default:
                    break startApp;
            }
        } while (true);
    }
}
