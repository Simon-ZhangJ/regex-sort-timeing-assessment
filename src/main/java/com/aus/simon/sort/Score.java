package com.aus.simon.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Score {

    public Score(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    private int id;
    private String name;
    private double GPA;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }
}
