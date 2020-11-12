package com.demo.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class printer {
    public printer(){}
    public void print(String st){
        FileOutputStream mytxt= null;
        try {
            mytxt = new FileOutputStream("D:/Login&Register/log.txt",true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = st.getBytes();
            for(int i =0; i<bytes.length; i++){
                try {
                    mytxt.write(bytes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}

