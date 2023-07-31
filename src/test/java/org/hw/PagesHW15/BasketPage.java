package org.hw.PagesHW15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
    private WebElement productTitleElement;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getProductTitleInBasket() {
      return productTitleElement.getText();
    }
}
