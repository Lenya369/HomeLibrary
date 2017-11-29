package com.leo.librarydatabase.Controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class InsertData {
    private static int numberOption ;

   public int InsertData() {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       try {
           numberOption = Integer.parseInt(reader.readLine());
       } catch (IOException e) {
           e.printStackTrace();
       }
       return numberOption;
   }

}
