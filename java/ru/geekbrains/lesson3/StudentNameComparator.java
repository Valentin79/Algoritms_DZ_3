package ru.geekbrains.lesson3;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

    private SortType sortType;

    public StudentNameComparator(SortType sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return sortType == SortType.Ascending ? o1.getName().compareTo(o2.getName()) :
                o2.getName().compareTo(o1.getName());
    }
}