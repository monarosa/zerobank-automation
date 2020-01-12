package com.zerobank.stepdefinitions;

import com.zerobank.pages.ZeroBankPayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class PayBillsStepDefinitions {

    ZeroBankPayBillsPage payBillsPage = new ZeroBankPayBillsPage();

    @Given("the user navigates to Pay Bills tab")
    public void the_user_navigates_to_Pay_Bills_tab() {
        payBillsPage.payBills.click();
    }

    @Then("the user selects payee {string}")
    public void the_user_selects_payee(String string) {
        payBillsPage.getSelectedOption(payBillsPage.selectPayee, string);
    }

    @Then("the user selects accounts {string}")
    public void the_user_selects_accounts(String string) {
        payBillsPage.getSelectedOption(payBillsPage.selectAccount, string);
    }

    @Then("the user enters the amounts {string}")
    public void the_user_enters_the_amounts(String string) {
        payBillsPage.amount.sendKeys(string);
    }

    @Then("the user choose the date {string}")
    public void the_user_choose_the_date(String string) {
        payBillsPage.date.sendKeys(string);
    }

    @Then("the user writes down description {string}")
    public void the_user_writes_down_description(String string) {
        payBillsPage.description.sendKeys(string);
    }

    @When("the user clicks on pay button")
    public void the_user_clicks_on_pay_button() {
        payBillsPage.pay.submit();
    }

    @Then("{string} is displayed")
    public void is_displayed(String string) {
        System.out.println(payBillsPage.errorMessage());
        System.out.println(string);

        Assert.assertEquals(string,payBillsPage.errorMessage());
        // below line checks validation, if imput bot is empty return false displays messages
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", payBillsPage.amount);
//        String message = (String)js.executeScript("return arguments[0].validationMessage;", payBillsPage.amount);
//        System.out.println(is_valid);
//        System.out.println(message);

    }


    @Then("Confirmation message is {string} is displayed")
    public void confirmationMessageIsIsDisplayed(String message) {
        Assert.assertEquals(message, payBillsPage.alert.getText());
    }

    @Then("{string} is not displayed")
    public void isNotDisplayed(String message) {

        Assert.assertTrue("The payment was successfully submitted. must not be displayed",!payBillsPage.alert.isDisplayed());
    }
}
