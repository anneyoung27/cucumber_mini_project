package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {

    }

    @When("User enters valid email address {string} into the email field")
    public void user_enters_valid_email_address_into_the_email_field(String validEmail) {

    }
    @When("User enters valid password {string} into the password field")
    public void user_enters_valid_password_into_the_password_field(String validPassword) {

    }
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {

    }
    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {

    }

    @When("User enters invalid email address {string} into email field")
    public void userEntersInvalidEmailAddressIntoEmailField(String invalidEmail) {
    }

    @And("User enters invalid password {string} into password field")
    public void userEntersInvalidPasswordIntoPasswordField(String invalidPassword) {

    }

    @Then("User should get a proper warning message about credentials")
    public void userShouldGetAProperWarningMessageAboutCredentials() {

    }

    @When("User don't enter email address into email field")
    public void userDonTEnterEmailAddressIntoEmailField() {

    }

    @And("User don't enter password into password field")
    public void userDonTEnterPasswordIntoPasswordField() {
    }
}
