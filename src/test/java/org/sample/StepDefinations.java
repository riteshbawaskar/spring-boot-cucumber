package org.sample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sample.adapters.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinations extends SpringIntegrationTest{

    @Autowired
    public FTPClient ftpClient;

    @Given("i enter {int}")
    public void iEnter(int arg0) {
        System.out.println("I have entered "+ arg0);
    }

    @When("i perform addition")
    public void iPerformAddition() {

        System.out.println("I am performing addition " );
        ftpClient.connect();
    }

    @Then("the result is {int}")
    public void theResultIs(int arg0) {
        System.out.println("I am checking result successfully ");
    }

}
