package keywords;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI extends DriverFactory {

    static Logger log = LogManager.getLogger();

    public static boolean checkElementExist(By by){
        List<WebElement> listElement = driver.findElements(by);

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
        driver.findElement(by).click();
        log.info("Click element: {}", by.toString());
    }

    public static void setText(By by, String value){
        waitForElementVisible(by);
        driver.findElement(by).sendKeys(value);
        log.info("Set text: {} on element {}", value, by);
    }



    // SYNCHRONIZATION
    public static void waitForElementVisible(By by){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("EXPLICIT_WAIT"))), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            log.warn("Timeout waiting for the element visible. {}", by.toString());
        }
    }
}
