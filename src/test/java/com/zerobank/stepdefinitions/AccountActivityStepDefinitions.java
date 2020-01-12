package com.zerobank.stepdefinitions;

import com.zerobank.pages.ZeroBankAccountActivityPage;
import com.zerobank.pages.ZerobankAccountSummaryPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AccountActivityStepDefinitions {

    ZeroBankAccountActivityPage accountActivityPage = new ZeroBankAccountActivityPage();
    ZerobankAccountSummaryPage accountSummaryPage = new ZerobankAccountSummaryPage();

    @Then("Account drop down default option is {string}")
    public void account_drop_down_default_option_is(String expected) {
        Select select = new Select(accountActivityPage.accountDropDown);
        Assert.assertEquals(expected, select.getFirstSelectedOption().getText());

    }

    @Then("Account drop down has the following options:")
    public void account_drop_down_has_the_following_options(io.cucumber.datatable.DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<String> actual = new ArrayList<>();
        Select select = new Select(accountActivityPage.accountDropDown);
        final List<WebElement> allOptions = select.getOptions();

        for (WebElement e : allOptions) {
            if (actual.contains(e.getText())) continue;
            actual.add(e.getText());
        }

        Assert.assertEquals(expected, actual);
    }

    @And("the user navigates to Account Activity tab")
    public void theUserNavigatesToAccountActivityTab() {
        Assert.assertTrue(accountActivityPage.accountActivityTab.isEnabled());
        accountActivityPage.accountActivityTab.click();
    }

    @Then("Transactions table has column names:")
    public void transactionsTableHasColumnNames(io.cucumber.datatable.DataTable dataTable) {
        List<String> expected = dataTable.asList();
        List<String> actual = new ArrayList<>();

        for (WebElement e : accountActivityPage.accountActivityTableHeader) {
            actual.add(e.getText());
        }
        Assert.assertEquals(expected, actual);
    }


    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnSavingsLinkOnTheAccountSummaryPage(String str) {
        accountSummaryPage.clickOnLinks(str);
    }

    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String selected) {
        Assert.assertEquals(accountActivityPage.getFirstSelected().toLowerCase(), selected.toLowerCase());
    }

    @Given("the user accesses the Find Transactions tab")
    public void theUserAccessesTheFindTransactionsTab() {
        accountActivityPage.accountActivityTab.click();
        accountActivityPage.findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String datefrom, String dateto) {
        accountActivityPage.dateFrom.clear();
        accountActivityPage.dateFrom.sendKeys(datefrom);
        accountActivityPage.dateTo.clear();
        accountActivityPage.dateTo.sendKeys(dateto);

    }

    @And("clicks search")
    public void clicksSearch() {
        accountActivityPage.findButton.submit();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String dateFrom, String dateTo) {
        LocalDate localDateFrom = LocalDate.parse(dateFrom);
        LocalDate localDateTo = LocalDate.parse(dateTo);

        System.out.println("date from is :" + localDateFrom);
        System.out.println("date to is   :" + localDateTo);

        List<WebElement> dateList = accountActivityPage.getDateList();


        for (WebElement date : dateList) {

            LocalDate localDate = LocalDate.parse(date.getText());
            System.out.println("date from website is " + localDate);
            Assert.assertTrue("requested transaction date is not found, it is either before or after the shown dates",
                    (localDate.isEqual(localDateTo) || localDate.isBefore(localDateTo)) && (localDate.isEqual(localDateFrom) || localDate.isAfter(localDateFrom)));

        }
    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() {

        List<WebElement> dateList = accountActivityPage.dateList;

        for (int i = 0; i < dateList.size() - 1; i++) {
            boolean sort = LocalDate.parse(dateList.get(i).getText()).isAfter(LocalDate.parse(dateList.get(i + 1).getText()));
            Assert.assertTrue(sort);
        }


    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String invalidDate) {

        for (WebElement e : accountActivityPage.getDateList()) {
            Assert.assertFalse("date " + invalidDate + " is under date header", e.getText().equals(invalidDate));
        }

    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String description) {
        accountActivityPage.description.clear();
        accountActivityPage.description.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContainingONLINE(String descriptionType) {
        try {
            for (WebElement element : accountActivityPage.getDescriptionList()) {
                Assert.assertTrue(element.getText().startsWith(descriptionType));
            }
        } catch (Exception e) {
            Assert.assertTrue("page does not display any result", accountActivityPage.noResult.getText().contains(descriptionType));
            e.printStackTrace();
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String descriptionType) {
        for (WebElement element : accountActivityPage.getDescriptionList()) {
            Assert.assertFalse("element not visible", element.getText().contains(descriptionType));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void resultsTableShouldShowAtLeastOneResultUnder(String transactionType) {
        switch (transactionType.toLowerCase()) {
            case "deposit":
                accountActivityPage.displayesAtLeastOneResult(accountActivityPage.getDepositList());
                break;
            case "withdrawal":
                accountActivityPage.displayesAtLeastOneResult(accountActivityPage.getWithdrawalList());
                break;
        }

    }


    @When("user selects type {string}")
    public void userSelectsTypeDeposit(String type) {
        Select select = new Select(accountActivityPage.typeDropDownFindTransaction);
        select.selectByVisibleText(type);

    }

    @But("results table should show no result under {string}")
    public void resultsTableShouldShowNoResultUnder(String transactionType) {

        switch (transactionType.toLowerCase()) {
            case "deposit":
                accountActivityPage.displayesZeroResult(accountActivityPage.getDepositList());
                break;
            case "withdrawal":
                accountActivityPage.displayesZeroResult(accountActivityPage.getWithdrawalList());
                break;
        }
    }
}
