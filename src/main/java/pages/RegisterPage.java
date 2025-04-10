package pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends WebUI {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    By goToRegisterForm = By.xpath("//a[normalize-space()='Continue']");
    By registerAccountPage = By.xpath("//h1[normalize-space()='Register Account']");

    By createFirstName = By.xpath("//input[@id='input-firstname'])");
    By createLastName = By.xpath("//input[@id='input-lastname']");
    By createNewEmail = By.xpath("//input[@id='input-email']");
    By createPassword = By.xpath("//input[@id='input-password']");
    By tickSubscribe = By.xpath("//input[@id='input-newsletter']");

    By privacyPolicy = By.xpath("//input[@name='agree']");
    By continueToRegister = By.xpath("//button[normalize-space()='Continue']");

    By errorFirstName = By.xpath("//div[@id='error-firstname']");
    By errorLastName = By.xpath("//div[@id='error-lastname']");
    By errorEmail = By.xpath("//div[@id='error-email']");
    By errorPassword = By.xpath("//div[@id='error-password']");

    By successfullyCreatedAccount = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By goToDashboardAccount = By.xpath("//a[normalize-space()='Continue']");

    public void goToRegisterFormPage(){
        clickElement(goToRegisterForm);
    }

    public String verifyRegisterPageIsVisible(){
        return getElementText(registerAccountPage);
    }

    public void setFirstName(String firstName){
        setText(createFirstName, firstName);
    }

    public void setLastName(String lastName){
        setText(createLastName, lastName);
    }

    public void setEmail(String email){
        setText(createNewEmail, email);
    }

    public void setPassword(String password){
        setText(createPassword, password);
    }

    public void tickSubscribeNewsletter(){
        waitForElementToBeClicked(tickSubscribe);
        clickElement(tickSubscribe);
    }

    public void selectPrivacyPolicy(){
        clickElement(privacyPolicy);
    }

    public void clickContinueToRegisterAccount(){
        waitForElementToBeClicked(continueToRegister);
        clickElement(continueToRegister);
    }

    public void closeAlertErrorMessage(){
        closeAlert();
    }

    public String getFirstNameError(){
        return getElementText(errorFirstName);
    }

    public String getLastNameError(){
        return getElementText(errorLastName);
    }

    public String getEmailError(){
        return getElementText(errorEmail);
    }

    public String getPasswordError(){
        return getElementText(errorPassword);
    }

    public String getSuccessCreatedAccount(){
        return getElementText(successfullyCreatedAccount);
    }

    public void clickContinueToGoToDashboardAccount(){
        waitForElementToBeClicked(goToDashboardAccount);
        clickElement(goToDashboardAccount);
    }


}
