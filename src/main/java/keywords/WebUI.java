package keywords;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI extends DriverFactory {

    static Logger log = LogManager.getLogger();

    public static WebElement getWebElement(By by){
        return driver.findElement(by);
    }

    public static List<WebElement> getWebElements(By by){
        return driver.findElements(by);
    }

    public static boolean checkElementExist(By by){
        List<WebElement> listElement = getWebElements(by);

        if (!listElement.isEmpty()){
            log.info("checkElementExists: " + true + " --- " + by);
            return true;
        }else {
            log.info("checkElementExists: " + false + " --- " + by);
            return false;
        }
    }

    public static void clickElement(By by){
        waitForElementVisible(by);
        getWebElement(by).click();
        log.info("Click element: {}", by.toString());
    }

    public static void setText(By by, String value){
        waitForElementVisible(by);
        getWebElement(by).sendKeys(value);
        log.info("Set text: {} on element {}", value, by);
    }

    public static String getElementText(By by){
        waitForElementVisible(by);
        String text = getWebElement(by).getText();
        log.info("Get text: {}", text);
        return text;
    }

    public static boolean isDisplayed(By by){
        waitForPageLoaded();
        boolean checkDisplay = driver.findElement(by).isDisplayed();
        log.info("Check element display {} \n=========> {}", by, checkDisplay);
        return checkDisplay;
    }

    // SYNCHRONIZATION
    public static void waitForElementVisible(By by){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("EXPLICIT_WAIT"))), Duration.ofMillis(Integer.parseInt(System.getProperty("MILLS"))));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            log.warn("Timeout waiting for the element visible. {}", by.toString());
        }
    }

    public static void waitForPageLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("EXPLICIT_WAIT"))), Duration.ofMillis(Integer.parseInt(System.getProperty("MILLS"))));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // wait for javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        // Check JS is ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        // Wait javascript until it is ready
        if (!jsReady) {
            log.info("Javascript is NOT ready");
            // Wait for Javascript to load
            try {
                wait.until(jsLoad);
            }catch (Throwable error){
                error.printStackTrace();
                log.warn("FAILED. Timeout waiting for page load");
            }
        }
    }

    public static void waitForElementPresent(By by){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("TIMEOUT"))), Duration.ofMillis(Integer.parseInt(System.getProperty("MILLS"))));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Throwable error){
            log.warn("Element not exists : {}", by.toString());
        }
    }

    public static void waitForElementToBeClicked(By by){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("TIMEOUT"))), Duration.ofMillis(Integer.parseInt(System.getProperty("MILLS"))));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Throwable error){
            log.warn("Timeout waiting for the element ready to click: {}", by.toString());
        }
    }

    public static void scrollToElement(By element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(element));
    }
}
