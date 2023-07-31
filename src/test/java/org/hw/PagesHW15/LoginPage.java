package org.hw.PagesHW15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement userPasswordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage enterUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    public LoginPage enterUserPassword(String userPassword) {
        userPasswordField.sendKeys(userPassword);
        return this;
    }

    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(webDriver);
    }

    public boolean loginButtonVisibility() {
       return loginButton.isDisplayed();
    }

    public MainPage userLogin() {
        enterUserName("standard_user");
        enterUserPassword("secret_sauce");
        clickLoginButton();
        return new MainPage(webDriver);
    }
}
