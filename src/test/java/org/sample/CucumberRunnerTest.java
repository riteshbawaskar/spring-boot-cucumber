package org.sample;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber-report/report.html"},
        glue = "org.sample")
public class CucumberRunnerTest extends SpringIntegrationTest  {
}


