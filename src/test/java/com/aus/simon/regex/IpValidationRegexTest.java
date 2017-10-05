package com.aus.simon.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aus.simon.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = {AppConfig.class})  
public class IpValidationRegexTest {
    @Autowired
    private IPValidationRegex regex;
    
    @Test
    public void regexTest() {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("IpAddress.txt");

            InputStreamReader read = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(read);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (!regex.isValid(line)) {
                    System.out.println(line);
                }
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
