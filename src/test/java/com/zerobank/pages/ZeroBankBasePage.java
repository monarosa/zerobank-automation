package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ZeroBankBasePage {
    private WebDriver driver;

    public ZeroBankBasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
}
