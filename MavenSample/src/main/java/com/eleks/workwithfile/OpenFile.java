package com.eleks.workwithfile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenFile {
    public String parseToString(String file) {
        String result = "";
        String sCurrentLine;
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader((file)));

            while ((sCurrentLine = br.readLine()) != null) {

                result = result + sCurrentLine;

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }
}
