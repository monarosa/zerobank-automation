package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HrAppDeptEmpPage extends ZeroBankBasePage  {

    @FindBy(id="pt1")
    public WebElement departmentID;

    @FindBy(id="vary")
    public WebElement departmentName;

    @FindBy(id="vary")
    public WebElement manager_ID;

    @FindBy(id="vary")
    public WebElement next;

    @FindBy(id="vary")
    public WebElement location_ID;



}
