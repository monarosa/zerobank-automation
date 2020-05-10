package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"},
        features = {"src/test/resources/features","src/test/resources/HrApp"},
        glue = "com/zerobank/stepdefinitions",
        dryRun = true,
        tags = "@Smoke or @Functional or @Regression or @data"
)
public class CukesRunner{
}
