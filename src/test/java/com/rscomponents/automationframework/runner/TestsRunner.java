package com.rscomponents.automationframework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( plugin ={"pretty", "html:target/cucumber", "junit:target/cucumber.xml"},
        features = "src/test/resources/features",
        glue = {"com.rscomponents.automationframework.stepsDefinitions"}
        )
public class TestsRunner {

}
