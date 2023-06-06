package com.andriiiiiko.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumbers {
    private static final String RELATIVE_PATH = "src/main/java/com/andriiiiiko/task1/file.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RELATIVE_PATH))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                if (isPhoneNumberValid(line)) {
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean isPhoneNumberValid(String line) {
        if (line.length() == 14) {
            if (line.charAt(0) == '(' && line.charAt(4) == ')' && line.charAt(5) == ' ' &&
                    line.charAt(9) == '-') {
                for (int i = 1; i <= 3; i++) {
                    if (!Character.isDigit(line.charAt(i))) {
                        return false;
                    }
                }
                for (int i = 6; i <= 8; i++) {
                    if (!Character.isDigit(line.charAt(i))) {
                        return false;
                    }
                }
                for (int i = 10; i <= 13; i++) {
                    if (!Character.isDigit(line.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        } else if (line.length() == 12) {
            if (line.charAt(3) == '-' && line.charAt(7) == '-') {
                for (int i = 0; i <= 2; i++) {
                    if (!Character.isDigit(line.charAt(i))) {
                        return false;
                    }
                }
                for (int i = 4; i <= 6; i++) {
                    if (!Character.isDigit(line.charAt(i))) {
                        return false;
                    }
                }
                for (int i = 8; i <= 11; i++) {
                    if (!Character.isDigit(line.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}