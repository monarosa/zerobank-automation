package com.zerobank.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties confige;
static
   {

        try {
            FileInputStream inputStream=new FileInputStream("configuration.properties");
            confige= new Properties();
            confige.load(inputStream);
            System.out.println("loaded configuration.properties file!");
        } catch (IOException e) {
            System.out.println("Failed to load configuration.properties file!");
            e.printStackTrace();
        }

    }

    public static String getProperty(String str){

        return confige.getProperty(str);
    }

}
