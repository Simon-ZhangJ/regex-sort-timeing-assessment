package com.aus.simon.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class IPValidationRegex {

    public boolean isValid(String ipAddr) {
        if (null == ipAddr || "".equals(ipAddr) || ipAddr.length() < 7 || ipAddr.length() > 15) {
            return false;
        }
        String rexp = "^(?:(?:25[0-5]?|2[0-4]?[0-9]?|[01]?[0-9][0-9]?)\\.){3}"
            + "(?:25[0-5]?|2[0-4]?[0-9]?|[01]?[0-9][0-9]?)$";
        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(ipAddr);
        return mat.matches();
    }

    public static void main(String[] args) {
        IPValidationRegex validator = new IPValidationRegex();
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("IpAddress.txt");

            InputStreamReader read = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(read);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (!validator.isValid(line)) {
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
