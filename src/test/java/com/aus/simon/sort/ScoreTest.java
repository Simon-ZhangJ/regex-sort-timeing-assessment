package com.aus.simon.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aus.simon.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = {AppConfig.class})  
public class ScoreTest {
    @Autowired
    private Sorter sorter;
    
    @Test
    public void sortTest() {
        List<Score> scoreList = new ArrayList<Score>() {
            {
                add(new Score(33, "Tina", 3.68));
                add(new Score(85, "Louis", 3.85));
                add(new Score(56, "Samil", 3.75));
                add(new Score(19, "Samar", 3.75));
                add(new Score(16, "Samar", 3.75));
                add(new Score(22, "Lorry", 3.76));
                add(new Score(13, "Tina", 3.68));
            }
        };
        
        sorter.sort(scoreList);
        
        for (Score s : scoreList) {
            System.out.println(s.getName() + " (GPA:" + s.getGPA() + ", ID:" + s.getId() + ")");
        }
    }
}
