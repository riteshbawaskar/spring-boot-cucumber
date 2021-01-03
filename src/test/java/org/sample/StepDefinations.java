package org.sample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations extends SpringIntegrationTest{

    @Given("i enter {int}")
    public void iEnter(int arg0) {
        System.out.println("I have entered "+ arg0);
    }

    @When("i perform addition")
    public void iPerformAddition() {

        System.out.println("I am performing addition ");
    }

    @Then("the result is {int}")
    public void theResultIs(int arg0) {
        System.out.println("I am checking result successfully ");
    }

}
