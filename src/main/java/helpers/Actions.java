package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static helpers.Utils.*;

public class Actions{


    protected WebDriver driver;

    public Actions(WebDriver driver) throws Exception {
        this.driver=driver;
        waitUntilPageisCompleted();
    }


    public void clickButton(String detailIdentifier) throws Exception {
        loadPage(detailIdentifier);
        waitUntilPageisCompleted();
        waitUntilElementIsVisible(detailIdentifier);
        waitUntilElementisClickable(detailIdentifier);
        driver.findElement(By.xpath(detailIdentifier)).click();
//        checkForServiceError();
    }


    public void type(String detailIdentifier, String text) throws Exception {
        if (checkIfValueIsSet(text)) {
            waitUntilElementLocated(detailIdentifier);
            waitUntilElementIsVisible(detailIdentifier);
            waitUntilElementisClickable(detailIdentifier);
            WebElement editbox = driver.findElement(By.xpath(detailIdentifier));
            switch (text) {
                case "randomText":
                    text = randomText();
                    break;
                case "sysdate":
                    text = formatDate("dd/MM/yyyy", getSysDate());
                    break;
            }
            //send the new text by sending CTRL+a to select all previous text (if any) and resending the new text
            editbox.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
//            checkForServiceError();
        }
    }

    public String getMessage(String detailIdentifier) throws Exception {
        waitUntilElementLocated(detailIdentifier);
        waitUntilElementIsVisible(detailIdentifier);
        return driver.findElement(By.xpath(detailIdentifier)).getText();
    }

    public String getTitle(String identifier) throws Exception {
        waitUntilElementIsVisible(identifier);
        waitUntilElementLocated(identifier);
        return driver.findElement(By.xpath(identifier)).getAttribute("title");
    }

    public String getElementValue(String identifier) throws Exception {
        waitUntilElementLocated(identifier);
        waitUntilElementIsVisible(identifier);
        return driver.findElement(By.xpath(identifier)).getAttribute("value");
    }

    public boolean checkIfValueIsSet(String value) {
        return value != null && !value.equals("");
    }

    public void loadPage(String detailIdentifier) throws Exception {
        waitUntilPageisLoaded();
        waitUntilInvisibilityofElement(".//*[contains(@class,'spinner')]");
//        checkForServiceError();
        waitUntilElementLocated(detailIdentifier);
    }



    // ############################## WAIT METHODS##############################


    public Duration getWaitForTimeout() throws Exception {
        Duration waitForTimeout = null;
        int configuredWaitForTimeoutInMilliseconds;

        CommonSystemParameters param = new CommonSystemParameters();
        String WebDriverWait = param.getWebDriverTimeOut();

        if (waitForTimeout == null) {
            configuredWaitForTimeoutInMilliseconds = Integer.parseInt(WebDriverWait);
            waitForTimeout = Duration.ofMillis(configuredWaitForTimeoutInMilliseconds);
        }
        return waitForTimeout;
    }

    public void waitUntilPageisCompleted() throws Exception {
        waitUntilPageisLoaded();
//        checkForServiceError();
//        waitAllSpinners();
//        waitPageReadyState();
//        checkForServiceError();
    }

    // implicit wait.
    public void waitUntilPageisLoaded() throws Exception {
        driver.manage().timeouts().pageLoadTimeout(getWaitForTimeout().getSeconds(), TimeUnit.SECONDS);
    }

    public void waitUntilElementIsVisible(String detailIdentifier) throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, getWaitForTimeout().getSeconds()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(detailIdentifier)));
    }

    public void waitUntilElementLocated(String detailIdentifier) throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, getWaitForTimeout().getSeconds()));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(detailIdentifier)));
    }

    public void waitUntilElementisClickable(String detailIdentifier) throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, getWaitForTimeout().getSeconds()));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(detailIdentifier)));
    }

    public void waitUntilInvisibilityofElement(String detailIdentifier) throws Exception {
        WebDriverWait wait = (new WebDriverWait(driver, getWaitForTimeout().getSeconds()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(detailIdentifier)));
    }



}
