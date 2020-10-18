package com.company.des;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextWorker{
    public static String read(String fileName){
        var file=new File(fileName);
        var ans=new StringBuilder();
        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert scanner != null;

        while(scanner.hasNextLine()){
            ans.append(scanner.nextLine());
        }
        scanner.close();
        return ans.toString();
    }
    static void write(String fileName, String text){
        try {
            FileWriter fileWriter=new FileWriter(fileName);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
