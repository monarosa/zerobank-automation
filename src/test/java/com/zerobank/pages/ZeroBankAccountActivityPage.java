package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en_lol.WEN;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ZeroBankAccountActivityPage extends ZeroBankBasePage {


    @FindBy(linkText = "Account Activity")
    public WebElement accountActivityTab;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropDown;


    @FindBy(css = ".table.table-condensed.table-hover th")
    public List<WebElement> accountActivityTableHeader;

    @FindBy(id = "aa_accountId")
    public WebElement accountActivityDropDown;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(tagName = "button")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//table//td[1]")
    public List<WebElement> dateList;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//table//td[2]")
    public List<WebElement> descriptionList;

    @FindBy(className = "well")
    public  WebElement noResult;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//table//td[3]")
    public List<WebElement> depositList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//table//td[4]")
    public List<WebElement> withdrawalList;

    @FindBy(id = "aa_type")
    public WebElement typeDropDownFindTransaction;

    public List<WebElement> getDateList() {
//waits for list is visible after clinking the find button
        Wait wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(this.dateList));

        return dateList;
    }


    public List<WebElement> getDescriptionList() {

        Wait wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(this.descriptionList));
        return descriptionList;

    }

    public List<WebElement> getDepositList() {

        Wait wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(this.depositList));
        return depositList;

    }

    public List<WebElement> getWithdrawalList() {

        Wait wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(this.withdrawalList));
        return withdrawalList;

    }


    public String getFirstSelected() {
        Select select = new Select(accountActivityDropDown);
        String selected = select.getFirstSelectedOption().getText();
        return selected;
    }


    public void displayesAtLeastOneResult(List<WebElement> element){
        List<WebElement> e = new ArrayList<>(element);

        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).getText().isEmpty()) {
                e.remove(e.get(i));

            }
        }
        System.out.println(e.size());
        Assert.assertTrue("it does not display anything", e.size() > 0);
    }

    public void displayesZeroResult(List<WebElement> element){
        List<WebElement> e = new ArrayList<>(element);

        for (int i = 0; i < e.size(); i++) {
            Assert.assertTrue("it displayes something", e.get(i).getText().isEmpty());

        }


    }

}
