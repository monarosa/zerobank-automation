package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZeroBankHomePage extends ZeroBankBasePage {

    @FindBy(id = "signin_button")
    public WebElement signinButton;

}
