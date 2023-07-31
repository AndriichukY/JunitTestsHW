package org.hw.HW14;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HW14SecondVariantTest {

@Test
    public void verifyLoginPositive() {
    WebDriver chromedriver = new ChromeDriver();

    chromedriver.get("https://the-internet.herokuapp.com/login");

    WebElement userNameField = chromedriver.findElement(By.id("username"));
    userNameField.sendKeys("tomsmith");

    WebElement userPasswordField = chromedriver.findElement(By.id("password"));
    userPasswordField.sendKeys("SuperSecretPassword!");

    WebElement loginButton = chromedriver.findElement(By.xpath("//button[@type=\"submit\"]"));
    loginButton.click();

    WebElement successMessage = chromedriver.findElement(By.xpath("//div[contains(text(), \" You logged into a secure area!\")]"));
        Assertions.assertTrue(successMessage.isDisplayed());

    chromedriver.quit();
    }

    @Test
    public void verifyLoginNegative() {
        WebDriver chromedriver = new ChromeDriver();

        chromedriver.get("https://the-internet.herokuapp.com/login");

        WebElement userNameField = chromedriver.findElement(By.id("username"));
        userNameField.sendKeys("test");

        WebElement userPasswordField = chromedriver.findElement(By.id("password"));
        userPasswordField.sendKeys("test Password");

        WebElement loginButton = chromedriver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click();

        WebElement successMessage = chromedriver.findElement(By.xpath("//div[contains(text(), \"  Your username is invalid!\")]"));
        Assertions.assertTrue(successMessage.isDisplayed());

        chromedriver.quit();
    }
}
