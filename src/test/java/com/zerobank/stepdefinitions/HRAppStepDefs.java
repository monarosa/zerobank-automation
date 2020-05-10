package com.zerobank.stepdefinitions;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class HRAppStepDefs {

    private WebDriver driver= Driver.getDriver();
    @Given("I am on DeptEmpPage")
    public void i_am_on_DeptEmpPage() {

        driver.get(ConfigurationReader.getProperty("HrApp.url"));

    }

    @When("I search for department id {int}")
    public void i_search_for_department_id(Integer int1) {

    }

    @Then("I query database with sql {string}")
    public void i_query_database_with_sql(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("UI Data and database data must macth")
    public void ui_Data_and_database_data_must_macth() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
