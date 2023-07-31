package org.hw.PagesHW15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@id=\"inventory_container\"]")
    private WebElement mainContent;
    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;

    @FindBy(id = "inventory_container")
    private WebElement itemsOnPage;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    private WebElement sortButton;

    @FindBy(xpath = "//option[@value=\"lohi\"]")
    private WebElement sortByLowToHighPriseOption;

    @FindAll({@FindBy(xpath = "//div[@class=\"inventory_item\"]//div[@class=\"inventory_item_price\"]")})
    private List<WebElement> itemsOnPAge;

    @FindBy(xpath = "//div[1][@class=\"inventory_item\"]//button[contains(text(), \"Add to cart\")]")
    private WebElement AddToCardButtonFirstItem;

    @FindBy(xpath = "//div[@class=\"inventory_item_name\"][1]")
    private WebElement productTitleFirstElement;

    @FindBy(id = "shopping_cart_container")
    private WebElement goToBasketButton;

    @FindBy(xpath = "//div[@class=\"bm-burger-button\"]")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@class=\"bm-menu\"]")
    private WebElement burgerMenuDropDown;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean getMainContentVisibility() {
        return mainContent.isDisplayed();
    }
    public BasketPage clickOnCartPage() {
        cartButton.click();
        return new BasketPage(webDriver);
    }
    public boolean getItemsOnPageVisibility() {
        return itemsOnPage.isDisplayed();
    }

    public MainPage sortItemsByLowToHighPrise() {
        sortButton.click();
        sortByLowToHighPriseOption.click();
        return this;
    }

    public Boolean areTheItemsSorted() {
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

    public MainPage addToCardFirstItem() {
        AddToCardButtonFirstItem.click();
        return this;
    }

   public String getFirstItemTittle() {
       return productTitleFirstElement.getText();
    }

    public BasketPage clickGoToBasketButton() {
        goToBasketButton.click();
        return new BasketPage(webDriver);
    }

    public MainPage clickMenuButton() {
        menuButton.click();
        WaitersUtil.explicitWaitOfClickable(webDriver, By.id("logout_sidebar_link"));
        return this;
    }

    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage(webDriver);
    }
}
