package com.zerobank.stepdefinitions;

import com.zerobank.pages.ZeroBankLoginPage;
import com.zerobank.pages.ZerobankAccountSummaryPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefinitions {

    ZeroBankLoginPage loginPage=new ZeroBankLoginPage();
    ZerobankAccountSummaryPage accountSummaryPage=new ZerobankAccountSummaryPage();
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.login();
    }

    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(DataTable dataTable) {
        List<String> expectedAccountType = dataTable.row(0);
        List<String> actualAccountType= new ArrayList<>();
        List<WebElement> accountType = accountSummaryPage.accountTypeHeaders;
        for(WebElement e: accountType){
            actualAccountType.add(e.getText());
        }
        Assert.assertEquals(expectedAccountType,actualAccountType);

    }

    @Then("Credit Accounts table must have columns:")
    public void credit_Accounts_table_must_have_columns(DataTable dataTable) {
        List<String> expected=dataTable.asList();

        List<String> actual=new ArrayList<>();

        final List<WebElement> creditAccountsTable = accountSummaryPage.creditAccountsTableFirstRow;
        for (WebElement e:creditAccountsTable){
            actual.add(e.getText());
        }

        Assert.assertEquals(expected,actual);

    }
}
