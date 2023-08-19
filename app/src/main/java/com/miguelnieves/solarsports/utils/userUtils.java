package com.miguelnieves.solarsports.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class userUtils {

    public static boolean checkUser(String userOrEmail, File filesDir) {
        File file = new File(filesDir, "userData.txt");
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> emailList = new ArrayList<>();
            List<String> userNameList = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                emailList.add(data[1]);
                userNameList.add(data[2]);
            }

            return emailList.contains(userOrEmail) || userNameList.contains(userOrEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkPassword(String userOrEmail, String password, File filesDir) {
        File file = new File(filesDir, "userData.txt");
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> emailList = new ArrayList<>();
            List<String> userNameList = new ArrayList<>();
            List<String> passwordList = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                emailList.add(data[1]);
                userNameList.add(data[2]);
                passwordList.add(data[3]);
            }

            return (emailList.contains(userOrEmail) || userNameList.contains(userOrEmail)) && (passwordList.contains(password));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
