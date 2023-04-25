package by.nhorushko.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Value
@RequiredArgsConstructor
public class Student implements Serializable {
    String name;
    List<Integer> grades = new ArrayList<>();

    public void addGrades(List<Integer> list) {
        grades.addAll(list);
    }

    public void removeGrade(int index) {
        grades.remove(index);
    }

    public void updateGrade(int index, int grade) {
        grades.set(index, grade);
    }
}
