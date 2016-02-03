package peaktech.set.test;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import peaktech.set.NavigatorFactory;

import java.util.logging.Logger;

public class LoginSteps {
    private static final Logger LOGGER = Logger.getLogger(LoginSteps.class.getName());

    @Given("^I navigate to the landing page$")
    public void given_I_navigate_to_the_landing_page() {
        LOGGER.info("Entering: I navigate to the landing page");
        NavigatorFactory.getNavigator().given_I_navigate_to_the_landing_page();
    }

    @When("^I try to login with '(.+)' credentials$")
    public void when_I_try_to_login(String credentialsType) {
        LOGGER.info("Entering: I try to login with " + credentialsType + " credentials");
        NavigatorFactory.getNavigator().when_I_try_to_login(credentialsType);
    }

    @Then("^I should see that I logged in '(.+)'$")
    public void then_I_login(String outcome) {
        LOGGER.info("Entering: I should see that I logged in " + outcome);
        NavigatorFactory.getNavigator().then_I_login(outcome);
    }
}
