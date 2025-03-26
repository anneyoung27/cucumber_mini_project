package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinitions {
    @Given("User opens the Application")
    public void userOpensTheApplication() {
    }

    @When("User enters valid product {string} into Search box field")
    public void userEntersValidProductIntoSearchBoxField(String arg0) {
    }

    @And("User clicks on Search button")
    public void userClicksOnSearchButton() {
    }

    @Then("User should get valid product displayed in search result")
    public void userShouldGetValidProductDisplayedInSearchResult() {
    }

    @When("User enters invalid product {string} into Search box field")
    public void userEntersInvalidProductIntoSearchBoxField(String arg0) {
    }

    @Then("User should get a message about no product matching")
    public void userShouldGetAMessageAboutNoProductMatching() {
    }

    @When("User don't enter any product name into Search box field")
    public void userDonTEnterAnyProductNameIntoSearchBoxField() {
    }
}
