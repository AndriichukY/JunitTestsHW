package org.hw;

import org.hw.PagesHW15.WaitersUtil;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW15TestsWithoutPageObject {
    static WebDriver chromeDriver;

    @BeforeAll
    public static void init() {
        chromeDriver = new ChromeDriver();
    }

    @BeforeEach
    public void openPage() {
        chromeDriver.get("https://www.saucedemo.com/");
        enterUserName("standard_user");
        enterUserPassword("secret_sauce");
        clickLoginButton();
    }

    @org.junit.jupiter.api.Test
    public void verifyLogin() {
        WebElement menuButton = chromeDriver.findElement(By.id("menu_button_container"));
        Assertions.assertTrue(menuButton.isDisplayed());
    }

    @Test
    public void verifyItemsOnPage() {
        WebElement listingWithProducts2 = chromeDriver.findElement(By.id("inventory_container"));
        Assertions.assertTrue(listingWithProducts2.isDisplayed());
    }

    @Test
    public void verifySorting() {
        sortItemsByLowToHighPrise();
        List<WebElement> itemsOnPAge = (List<WebElement>) chromeDriver.findElements(By.xpath("//div[@class=\"inventory_item\"]//div[@class=\"inventory_item_price\"]"));
        Assertions.assertTrue(areTheArraySorted(itemsOnPAge));
    }

    @Test
    public void verifyAddedItemsToBasket() {
        addToCardFirstAndThirdItem();
        String tittleOfFirstItem = getProductTitleByIndex(1);
        String tittleOfThirdItem = getProductTitleByIndex(3);
        clickGoToBasketButton();
        WebElement getTittleFirstItemInCard = chromeDriver.findElement(By.xpath("//div[@class=\"cart_item\"]//div[contains(text(), \"" + tittleOfFirstItem + "\" )]"));
        WebElement getTittleThirdItemInCard = chromeDriver.findElement(By.xpath("//div[@class=\"cart_item\"]//div[contains(text(), \"" + tittleOfThirdItem + "\" )]"));
        Assertions.assertTrue(getTittleFirstItemInCard.isDisplayed());
        Assertions.assertTrue(getTittleThirdItemInCard.isDisplayed());

    }

    @Test
    public void verifyLogout() throws InterruptedException {
        clickMenuButton();
        WaitersUtil.explicitWaitOfClickable(chromeDriver, By.id("logout_sidebar_link"));
        clickLogoutButton();
        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        Assertions.assertTrue(loginButton.isDisplayed());
    }

    private String getProductTitleByIndex(int index) {
        WebElement productTitleElement = chromeDriver.findElement(By.xpath("(//div[@class='inventory_item_name'])[" + index + "]"));
        return productTitleElement.getText();
    }

    public void enterUserName(String userName) {
        WebElement userNameField = chromeDriver.findElement(By.id("user-name"));
        userNameField.sendKeys(userName);
    }

    public void enterUserPassword(String password) {
        WebElement userPasswordField = chromeDriver.findElement(By.id("password"));
        userPasswordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();
    }

    public void clickMenuButton() {
        WebElement menuButton = chromeDriver.findElement(By.xpath("//div[@class=\"bm-burger-button\"]"));
        menuButton.click();
    }

    public void sortItemsByLowToHighPrise() {
        WebElement sortButton = chromeDriver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
        sortButton.click();
        WebElement sortByLowToHighPriseOption = chromeDriver.findElement(By.xpath("//option[@value=\"lohi\"]"));
        sortByLowToHighPriseOption.click();
    }

    public static Boolean areTheArraySorted(List<WebElement> itemsOnPAge) {
        for (int i = 0; i < itemsOnPAge.size() - 1; i++){
            WebElement currentElement = itemsOnPAge.get(i);
            WebElement nextElement = itemsOnPAge.get(i + 1);

            double currentPrice = Double.parseDouble(currentElement.getText().replace("$", ""));;
            double nextPrice = Double.parseDouble(nextElement.getText().replace("$", ""));;

            if (currentPrice > nextPrice) {
                return false;
            }
        }
        return true;
    }

    public void addToCardFirstAndThirdItem() {
        WebElement AddToCardButtonFirstItem = chromeDriver.findElement(By.xpath("//div[1][@class=\"inventory_item\"]//button[contains(text(), \"Add to cart\")]"));
        WebElement AddToCardButtonThirdItem = chromeDriver.findElement(By.xpath("//div[3][@class=\"inventory_item\"]//button[contains(text(), \"Add to cart\")]"));

        AddToCardButtonFirstItem.click();
        AddToCardButtonThirdItem.click();
    }

    public void clickGoToBasketButton() {
        WebElement goToBasketButton = chromeDriver.findElement(By.id("shopping_cart_container"));
        goToBasketButton.click();
    }

    public void clickLogoutButton() {
        WebElement logoutButton = chromeDriver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }

    @AfterAll
    public static void clear() {
        chromeDriver.quit();
    }
}
