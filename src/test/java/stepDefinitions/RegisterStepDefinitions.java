package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RegisterPage;

import java.util.Map;

public class RegisterStepDefinitions extends DriverFactory {
    RegisterPage registerPage = new RegisterPage(driver);

    @And("User clicks on continue button to register new account")
    public void userClicksOnContinueButtonToRegisterNewAccount() {
        registerPage.goToRegisterFormPage();

        String registerPageIsVisible = registerPage.verifyRegisterPageIsVisible();
        Assert.assertEquals(registerPageIsVisible, "Register Account");
    }

    @When("User enters the details into below fields")
    public void userEntersTheDetailsIntoBelowFields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap();

        registerPage.setFirstName(dataMap.get("firstName"));
        registerPage.setLastName(dataMap.get("lastName"));
        registerPage.setEmail(dataMap.get("email"));
        registerPage.setPassword(dataMap.get("password"));
    }

    @And("User selects Privacy Policy")
    public void userSelectsPrivacyPolicy() {
        registerPage.selectPrivacyPolicy();
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        registerPage.clickContinueToRegisterAccount();
    }

    @Then("User account should get created successfully")
    public void userAccountShouldGetCreatedSuccessfully() {
    }

    @And("User selects Yes for Newsletter")
    public void userSelectsYesForNewsletter() {
        registerPage.tickSubscribeNewsletter();
    }

    @Then("User account should get a proper warning about duplicate email")
    public void userAccountShouldGetAProperWarningAboutDuplicateEmail() {
        registerPage.closeAlertErrorMessage();
    }

    @When("User don't enter any details into field")
    public void userDonTEnterAnyDetailsIntoField(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap();

        registerPage.setFirstName(dataMap.get(""));
        registerPage.setLastName(dataMap.get(""));
        registerPage.setEmail(dataMap.get(""));
        registerPage.setPassword(dataMap.get(""));
    }

    @Then("User should get proper warning messages for every mandatory field")
    public void userShouldGetProperWarningMessagesForEveryMandatoryField() {
        String actualErrorFirstNameMessage = registerPage.getFirstNameError();
        Assert.assertEquals(actualErrorFirstNameMessage, "First Name must be between 1 and 32 characters!");

        String actualErrorLastNameMessage = registerPage.getLastNameError();
        Assert.assertEquals(actualErrorLastNameMessage, "Last Name must between 1 and 32 characters!");

        String actualErrorEmailMessage = registerPage.getEmailError();
        Assert.assertEquals(actualErrorEmailMessage, "E-Mail Address does not appear to be valid!");

        String actualErrorPasswordMessage = registerPage.getPasswordError();
        Assert.assertEquals(actualErrorPasswordMessage, "Password must be between 4 and 20 characters!");
    }


}
