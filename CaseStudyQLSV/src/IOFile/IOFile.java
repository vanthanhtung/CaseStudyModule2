package IOFile;

import Entities.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static void WriteFile(ArrayList<Student> arrayList, String destPath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(arrayList);
        objectOutputStream.close();
    }

    public static ArrayList<Student> ReadFile(String sourcePath) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(sourcePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayList<Student>) objectInputStream.readObject();
    }
}
