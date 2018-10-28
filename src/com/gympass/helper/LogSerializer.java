package com.gympass.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LogSerializer {

    public static ArrayList<String[]> getLinesSplitted(String filePath){
        File file = new File(filePath);
        ArrayList<String[]> splittedLines = new ArrayList<String[]>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split("[–\\s\\t]+");
                splittedLines.add(splittedLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return splittedLines;
    }

}
