package com.zerobank.stepdefinitions;

import com.zerobank.pages.ZeroBankHomePage;
import com.zerobank.pages.ZeroBankLoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefinitions {
    ZeroBankLoginPage loginPage = new ZeroBankLoginPage();
    ZeroBankHomePage homePage = new ZeroBankHomePage();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Given("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        homePage.signinButton.click();
    }

    @Given("user log in with username {string} and password {string}")
    public void user_log_in_with_username_and_password(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.signIn.click();
    }

    @Then("{string} page is displayed")
    public void page_is_displayed(String title) {
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertTrue("Title is not what I expected",Driver.getDriver().getTitle().toLowerCase().contains(title.toLowerCase()));
    }

    @Then("{string} page is not displayed")
    public void page_is_not_displayed(String title) {
        Assert.assertFalse(Driver.getDriver().getTitle().contains(title));
    }

    @Then("error message {string} is displayed")
    public void error_message_is_displayed(String message) {
            Assert.assertTrue(loginPage.errorAlert.isDisplayed());
            Assert.assertEquals("Login and/or password are wrong.",message);    }

}
