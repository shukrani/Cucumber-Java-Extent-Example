package com.example.ui.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class WaitHelper {
	Logger logger = Logger.getLogger(WaitHelper.class);

	public void waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		logger.debug("Waitting for elelment");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.debug("Element is visible now");
	}
}
