package pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebUI {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    By emailAddressTextBox = By.xpath("//input[@id='input-email']");
    By passwordTextBox = By.xpath("//input[@id='input-password']");
    By loginButton = By.xpath("//button[normalize-space()='Login']");
    By successfullyLogin = By.xpath("//h2[normalize-space()='My Account']");
    By myAccount = By.cssSelector("a[href='https://demo.opencart.com/en-gb?route=account/account']");

    public void setEmailAddress(String email){
        setText(emailAddressTextBox, email);
    }

    public void setPassword(String password){
        setText(passwordTextBox, password);
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public boolean verifySuccessfullyLogin(){
        return isDisplayed(successfullyLogin);
    }

    public void closeAlertToastMessage(){
        closeAlert();
    }

    public void goToLoginPage(){
        scrollToElement(myAccount);

        waitForElementToBeClicked(myAccount);

        clickElement(myAccount);
    }



}
