package by.nhorushko.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Value
@RequiredArgsConstructor
public class Student {

    String name;
    List<Integer> grades = new ArrayList<>();

    public void addGrades(List<Integer> list) {
        grades.addAll(list);
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public void removeGrade(int index) {
        grades.remove(index);
    }
}
