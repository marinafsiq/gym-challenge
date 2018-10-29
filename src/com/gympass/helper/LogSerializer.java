package com.gympass.helper;

import java.io.*;
import java.util.ArrayList;

public class LogSerializer {

    public static ArrayList<String[]> getLinesSplitted(String filePath){
        File file = new File(filePath);
        ArrayList<String[]> splittedLines = new ArrayList<String[]>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedLine = line.split("[–\\s\\t]+");
                splittedLines.add(splittedLine);
            }
        }catch (IOException e){
            System.out.println("Your file may be corrupted. Please, check it!");
        }

        return splittedLines;
    }

}
