package com.nttdata;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/cucumber.json"},
        stepNotifications = true,
        features = "classpath:features",
        tags = "@Test"   //  ==> Definir el @tag  a ejecutar
)
public class CucumberTestSuite {
}
