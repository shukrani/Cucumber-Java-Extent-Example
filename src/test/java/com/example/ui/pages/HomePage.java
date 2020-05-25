package com.example.ui.pages;

import com.example.ui.helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class HomePage {
    private static Logger log = Logger.getLogger(HomePage.class);
    public WebDriver driver;
    WaitHelper wait;
    private static HomePage Homepage_instance = null;

    @FindBy(id = "loginbutton")
    public WebElement loginButton;

    public static HomePage getInstance(WebDriver driver)
    {

        if (Homepage_instance == null)
            Homepage_instance = new HomePage(driver);

        return Homepage_instance;
    }
    private HomePage(WebDriver webdriver)
     {
         driver = webdriver;
         wait = new WaitHelper();
         PageFactory.initElements(driver, this);
     }

    public void clickOnLoginButton()
    {
        loginButton.click();
    }

    public void verifyHomePage() {
        wait.waitForElement(driver,loginButton,5);
        Assert.assertTrue(driver.getCurrentUrl().contains("index"));
    }
}
