package edu.citadel.main.BDD_Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class BDD_TestRunner {
    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/test/edu.citadel.main/BDD_Cucumber")
    public class CucumberIntegrationTest {

    }
}
