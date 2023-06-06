package com.andriiiiiko.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private static final String RELATIVE_PATH_TXT = "src/main/java/com/andriiiiiko/task2/file.txt";
    private static final String RELATIVE_PATH_JSON = "src/main/java/com/andriiiiiko/task2/user.json";

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RELATIVE_PATH_TXT))) {
            String line = bufferedReader.readLine();
            boolean isHeader = true;
            while (line != null) {
                if (isHeader) {
                    line = bufferedReader.readLine();
                    isHeader = false;
                    continue;
                }
                String[] userData = line.split(" ");
                User user = new User(userData[0], Integer.parseInt(userData[1]));
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try (FileWriter fileWriter = new FileWriter(RELATIVE_PATH_JSON)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, fileWriter);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}