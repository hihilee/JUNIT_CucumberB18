package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1.We created properties object
    private static Properties properties = new Properties();
    //We want everything to be run once at the beginning of class

    //We cant write directly to inside of class!!
    //in order to load and run it once and at the beginning we use static blog
    static{

        //2.We get the path by right clicking and stored that in String or directly pass into fileInputStream object
        String path="configuration.properties";

        try{
            //3- We need to open the file
            FileInputStream file=new FileInputStream(path);
            //4- We need to load the file to properties object
            properties.load(file);
            //5- close.file
            file.close();

        }catch(IOException e){
            System.out.println("properties file not found");
            //it will be executed if we put wrong path or if we remove the file.
        }
    }


    //Our own custom method to read and get the values from configuration.properties file
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
