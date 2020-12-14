package com.example.ui.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseWeb {
    static WebDriver driver;
    static String browserName,websiteURL;

    public static WebDriver getDriver() {

        if (driver == null) {

            ConfigFileReader configFileReader = new ConfigFileReader();
            browserName = configFileReader.getPropertyValues("browser");
            websiteURL = configFileReader.getPropertyValues("url");
            if (browserName.contains("firefox") || browserName.contains("ff")) {
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
            }
            if (browserName.contains("chrome") || browserName.contains("cr")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        driver.get(websiteURL);
        return driver;

    }

    public static void closeBrowser() {
        if (driver != null)
            driver.quit();
    }


    public static void takeScreenshot(String name) {
        File screenshotdirectory = new File("test-output/Screenshots");

        if (!screenshotdirectory.exists()) {
            screenshotdirectory.mkdir();
        }
        try {
            String fileName = screenshotdirectory + "/" + name + System.currentTimeMillis() + ".png";
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File(fileName));

            System.out.println("Screenshot taken - " + fileName);
        } catch (Exception e) {

            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

}
