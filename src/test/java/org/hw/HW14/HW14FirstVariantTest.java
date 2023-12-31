package org.hw.HW14;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW14FirstVariantTest {

    static WebDriver chromeDriver;

    @BeforeAll
    public static void init() {
       chromeDriver = new ChromeDriver();
    }

    @BeforeEach
    public void openPage() {
        chromeDriver.get("https://the-internet.herokuapp.com/login");
    }

    @org.junit.jupiter.api.Test
    public void verifyLogin() {
        enterUserName("tomsmith");
        enterUserPassword("SuperSecretPassword!");
        clickLoginButton();
        WebElement loginSuccess = chromeDriver.findElement(By.xpath("//div[contains(text(), \" You logged into a secure area!\")]"));
        Assertions.assertTrue(loginSuccess.isDisplayed());
    }

    @Test
    public void verifyLoginNegative() {
        enterUserName("test");
        enterUserPassword("test password");
        clickLoginButton();
        WebElement loginFail = chromeDriver.findElement(By.xpath("//div[contains(text(), \"  Your username is invalid!\")]"));
        Assertions.assertTrue(loginFail.isDisplayed());
    }

    public void enterUserName(String userName) {
        WebElement userNameField = chromeDriver.findElement(By.id("username"));
        userNameField.sendKeys(userName);
    }

    public void enterUserPassword(String password) {
        WebElement userPasswordField = chromeDriver.findElement(By.id("password"));
        userPasswordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = chromeDriver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();
    }

    @AfterAll
    public static void clear() {
        chromeDriver.quit();
    }
}
