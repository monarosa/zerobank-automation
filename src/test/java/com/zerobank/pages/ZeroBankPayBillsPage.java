package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ZeroBankPayBillsPage extends ZeroBankBasePage {
    @FindBy(linkText = "Pay Bills")
    public WebElement payBills;

    @FindBy(id = "sp_payee")
    public WebElement selectPayee;

    @FindBy(id="sp_account")
    public WebElement selectAccount;

    @FindBy(id="sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public  WebElement description;

    @FindBy(id="pay_saved_payees")
    public WebElement pay;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement alert;



    public void getSelectedOption(WebElement element, String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }


    public String errorMessage(){

//        if (!payBillsPage.amount.getAttribute("validationMessage").isEmpty()) {
//            System.out.println(payBillsPage.amount.getAttribute("validationMessage"));
//            Assert.assertEquals(string,payBillsPage.amount.getAttribute("validationMessage"));
//        }
//       else if (!payBillsPage.date.getAttribute("validationMessage").isEmpty()) {
//            System.out.println(payBillsPage.date.getAttribute("validationMessage"));
//            Assert.assertEquals(string,payBillsPage.date.getAttribute("validationMessage"));
//        }
//        else {
//            Assert.assertEquals(string, payBillsPage.alert.getText());
//        }



        if(!this.amount.getAttribute("validationMessage").isEmpty()){
            return this.amount.getAttribute("validationMessage"); }
        else { return this.date.getAttribute("validationMessage"); }
    }
}
