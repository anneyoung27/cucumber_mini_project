package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginStepDefinitions extends DriverFactory {
    LoginPage loginPage;

    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("User enters valid email address {string} into the email field")
    public void user_enters_valid_email_address_into_the_email_field(String validEmail) {
        loginPage.setEmailAddress(validEmail);
    }

    @When("User enters valid password {string} into the password field")
    public void user_enters_valid_password_into_the_password_field(String validPassword) {
        loginPage.setPassword(validPassword);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        Assert.assertTrue(loginPage.verifySuccessfullyLogin(), "Successfully logged in to account!");
    }

    @When("User enters invalid email address {string} into email field")
    public void userEntersInvalidEmailAddressIntoEmailField(String invalidEmail) {
        loginPage.setEmailAddress(invalidEmail);
    }

    @And("User enters invalid password {string} into password field")
    public void userEntersInvalidPasswordIntoPasswordField(String invalidPassword) {
        loginPage.setPassword(invalidPassword);
    }

    @Then("User should get a proper warning message about credentials")
    public void userShouldGetAProperWarningMessageAboutCredentials() {
        loginPage.closeAlertToastMessage();
    }

    @When("User don't enter email address into email field")
    public void userDonTEnterEmailAddressIntoEmailField() {
        loginPage.setEmailAddress("");
    }

    @And("User don't enter password into password field")
    public void userDonTEnterPasswordIntoPasswordField() {
        loginPage.setPassword("");
    }
}
