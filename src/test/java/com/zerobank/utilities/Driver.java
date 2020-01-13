package com.zerobank.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private Driver() {
    }

    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {

            String browser = "";
            if (System.getProperty("browser") == null) {
                browser = ConfigurationReader.getProperty("browser");
            } else {
                browser = System.getProperty("browser");
            }

            switch (browser) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new RuntimeException("browser type is not configured correctly in config file");


            }


        }
        return driver;
    }


    public static void close() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}



