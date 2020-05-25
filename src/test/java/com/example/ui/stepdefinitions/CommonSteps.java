package com.example.ui.stepdefinitions;

import com.example.ui.helper.BaseWeb;
import com.example.ui.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    private HomePage homePage;
    public static WebDriver driver = BaseWeb.getDriver();

    public CommonSteps() {
        homePage = HomePage.getInstance(driver);
    }
    @Given("^I am on home page$")
    public void i_am_on_home_page() throws Throwable {
        homePage.verifyHomePage();
    }

    @When("^Click on login button$")
    public void click_on_login_button() throws Throwable {
        homePage.clickOnLoginButton();
    }

    @When("^I enter login details$")
    public void i_enter_login_details() throws Throwable {

    }

    @Then("^login form gets open$")
    public void login_form_gets_open() throws Throwable {

    }

    @Then("^I am successfully logged in$")
    public void i_am_successfully_logged_in() throws Throwable {

    }

}