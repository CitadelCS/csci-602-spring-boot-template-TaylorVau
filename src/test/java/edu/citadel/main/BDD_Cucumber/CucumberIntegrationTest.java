package edu.citadel.main.BDD_Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "edu.citadel.main.BDD_Cucumber",
        plugin = {"pretty"},
        monochrome = true
)
public class CucumberIntegrationTest { }
