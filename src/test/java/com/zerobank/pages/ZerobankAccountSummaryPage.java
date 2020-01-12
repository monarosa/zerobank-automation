package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZerobankAccountSummaryPage extends ZeroBankBasePage {

    @FindBy(tagName = "h2")
    public List<WebElement> accountTypeHeaders;

    @FindBy(xpath = "//h2[contains(.,'Credit Accounts')]/../div[3]//th")
    public List<WebElement> creditAccountsTableFirstRow;

    @FindBy(xpath = "//a[contains(.,'Savings')][@href='/bank/account-activity.html?accountId=1']")
    public WebElement savings;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCards;

    @FindBy(linkText = "Loan")
    public WebElement loan;


    public void clickOnLinks(String link) {
        switch (link.toLowerCase()) {
            case "savings":
                savings.click();
                break;
            case "brokerage":
                brokerage.click();
                break;
            case "checking":
                checking.click();
                break;
            case "credit card":
                creditCards.click();
                break;
            case "loan":
                loan.click();
                break;
            default:
                throw new RuntimeException("invalid link selection, check spelling");
        }

    }


}
