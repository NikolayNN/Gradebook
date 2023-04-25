package by.nhorushko.model;

import lombok.Value;

import java.io.*;
import java.util.*;

@Value
public class StudentDatabase implements Serializable {
    Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public void updateGrade(String name, int index, int grade) {
        getStudent(name)
                .ifPresent(s -> s.updateGrade(index, grade));
    }

    public void addGrade(String name, List<Integer> grades) {
        getStudent(name)
                .ifPresent(s -> s.addGrades(grades));
    }

    public void removeGrade(String name, int index) {
        getStudent(name)
                .ifPresent(s -> s.removeGrade(index));
    }

    public List<Integer> getGrades(String name) {
        return getStudent(name)
                .map(Student::getGrades)
                .orElse(List.of());
    }

    public Set<String> getAllStudentNames() {
        return students.keySet();
    }

    public void saveToFile(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
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

    private Optional<Student> getStudent(String name) {
        Student student = students.get(name);
        if (student == null) {
            throw new RuntimeException("Student " + name + " not found");
        }
        return Optional.ofNullable(student);
    }

    public void checkExist(String name) {
        getStudent(name);
    }
}
