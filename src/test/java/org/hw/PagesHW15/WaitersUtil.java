package org.hw.PagesHW15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitersUtil {

    public static WebElement explicitWaitOfVisibility(WebDriver webDriver, By by) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement explicitWaitOfClickable(WebDriver webDriver, By by) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        return explicitWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void explicitWaitOfInvisibility(WebDriver webDriver, By by) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void customExplicitWaiterOfLoading(WebDriver webDriver, By by) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        
         explicitWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElements(by).size() > 0;
            }
        });
    }
}
