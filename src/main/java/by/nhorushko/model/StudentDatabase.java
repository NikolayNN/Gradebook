package by.nhorushko.model;

import lombok.Value;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Value
public class StudentDatabase {
    Map<String, Student> students = new HashMap<>();

    public void addStudent(String name) {
        students.put(name, new Student(name));
    }

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public void addGrade(String name, int grade) {
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Student " + name + " not found");
            return;
        }
        student.addGrade(grade);
    }

    public void addGrade(String name, List<Integer> grades) {
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Student " + name + " not found");
            return;
        }
        student.addGrades(grades);
    }

    public void removeGrade(String name, int index) {
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Student " + name + " not found");
            return;
        }
        try {
            student.removeGrade(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + index);
        }
    }

    public List<Integer> getGrades(String name) {
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Student " + name + " not found");
            return null;
        }
        return student.getGrades();
    }

    public Map<String, List<Integer>> getAllGrades() {
        Map<String, List<Integer>> allGrades = new HashMap<>();
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            allGrades.put(entry.getKey(), entry.getValue().getGrades());
        }
        return allGrades;
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Map<String, Student> temp = (Map<String, Student>) ois.readObject();
            students.clear();
            students.putAll(temp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        students.clear();
    }
}
