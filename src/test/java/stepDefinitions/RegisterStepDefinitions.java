package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinitions {
    @When("User enters the details into below fields")
    public void userEntersTheDetailsIntoBelowFields() {
    }

    @And("User selects Privacy Policy")
    public void userSelectsPrivacyPolicy() {
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
    }

    @Then("User account should get created successfully")
    public void userAccountShouldGetCreatedSuccessfully() {
    }

    @And("User selects Yes for Newsletter")
    public void userSelectsYesForNewsletter() {
    }

    @Then("User account should get a proper warning about duplicate email")
    public void userAccountShouldGetAProperWarningAboutDuplicateEmail() {
    }

    @When("User don't enter any details into field")
    public void userDonTEnterAnyDetailsIntoField() {
    }

    @Then("User should get proper warning messages for every mandatory field")
    public void userShouldGetProperWarningMessagesForEveryMandatoryField() {
    }
}
