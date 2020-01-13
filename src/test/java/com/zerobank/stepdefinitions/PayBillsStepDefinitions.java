package com.zerobank.stepdefinitions;

import com.zerobank.pages.ZeroBankPayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        Assert.assertEquals(string, payBillsPage.errorMessage());
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

        Assert.assertTrue("The payment was successfully submitted. must not be displayed", !payBillsPage.alert.isDisplayed());
    }

    @Given("Add New Payee tab")
    public void addNewPayeeTab() {
        payBillsPage.addNewPayee.click();
    }

    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String, String> map) {
        payBillsPage.payeeNameInput.sendKeys(map.get("Payee Name"));
        payBillsPage.payeeAddressInput.sendKeys(map.get("Payee Address"));
        payBillsPage.payeeAccountInput.sendKeys(map.get("Account"));
        payBillsPage.payeeDetailsInput.sendKeys(map.get("Payee details"));


    }

    @And("clicks add")
    public void clicksAdd() {
        payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        Assert.assertEquals(payBillsPage.newPayeeConfirmationMessage.getText(), message);
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void theUserAccessesThePurchaseForeignCurrencyCashTab() {
        payBillsPage.purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(DataTable dataTable) {
        Select select=new Select(payBillsPage.currencyDropDown);
        List<WebElement> allSelectedOptions = select.getOptions();
        List<String> selectedOptionsString=new ArrayList<>();
        for(WebElement element:allSelectedOptions){
            selectedOptionsString.add(element.getText());
        }

        List<String> listofExpectedCurrency=dataTable.asList();
        System.out.println(selectedOptionsString);
        System.out.println(listofExpectedCurrency);
        Assert.assertTrue(selectedOptionsString.containsAll(listofExpectedCurrency));

    }

    @When("user tries to calculate cost without (selecting a currency)/(entering a value)")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        payBillsPage.calculateCostsButton.click();
    }


    @Then("error popup message {string} is displayed")
    public void errorPopupMessagePleaseEnsureThatYouHaveFilledAllTheRequiredFieldsWithValidValuesIsDisplayed(String expected) {
        String actual = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(expected,actual);
        Driver.getDriver().switchTo().alert().accept();
    }
}

