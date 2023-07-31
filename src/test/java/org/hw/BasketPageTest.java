package org.hw;

import org.hw.PagesHW15.LoginPage;
import org.hw.PagesHW15.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketPageTest extends BaseTestClass {

    @Test
    public void verifyAddedItemsToBasket() {

        String addedItemFromListing = new LoginPage(chromeDriver)
                .userLogin()
                .addToCardFirstItem()
                .getFirstItemTittle();

        String itemInBasket = new MainPage(chromeDriver)
                .clickGoToBasketButton()
                .getProductTitleInBasket();

        Assertions.assertEquals(addedItemFromListing, itemInBasket);
    }
}
