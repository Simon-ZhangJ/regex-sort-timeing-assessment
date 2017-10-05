package com.aus.simon.sort;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Sorter {
    public void sort(List<Score> scoreList) {

        scoreList.sort(Comparator.comparing(Score::getGPA).reversed()
            .thenComparing(Score::getName).thenComparing(Score::getId));

    }
}
