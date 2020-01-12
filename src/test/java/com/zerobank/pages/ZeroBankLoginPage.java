package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroBankLoginPage extends ZeroBankBasePage{


    @FindBy(id = "user_login")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement signIn;

    @FindBy(css = ".alert.alert-error")
    public WebElement errorAlert;


    public void login(){
        BrowserUtils.waitForPageTitle(ConfigurationReader.getProperty("login_page_title"));
        BrowserUtils.wait(1);
        username.sendKeys(ConfigurationReader.getProperty("username"));
        BrowserUtils.wait(1);
        password.sendKeys(ConfigurationReader.getProperty("password"));
        signIn.click();
    }

}
