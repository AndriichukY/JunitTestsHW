package org.hw;

import org.hw.PagesHW15.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MainPageTest extends BaseTestClass{
    @Test
    public void verifyItemsOnPage() {

        boolean itemsOnPageAreDisplayed = new LoginPage(chromeDriver)
                .userLogin()
                .getItemsOnPageVisibility();

        Assertions.assertTrue(itemsOnPageAreDisplayed);
    }

    @Test
    public void verifySortingOfItemsPage() {

        boolean itemsOnPageAreDisplayed = new LoginPage(chromeDriver)
                .userLogin()
                .sortItemsByLowToHighPrise()
                        .areTheItemsSorted();

        Assertions.assertTrue(itemsOnPageAreDisplayed);
    }

    @Test
    public void verifyLogout() {

        boolean successLogout = new LoginPage(chromeDriver)
                .userLogin()
                .clickMenuButton()
                .clickLogoutButton()
                .loginButtonVisibility();
        Assertions.assertTrue(successLogout);
    }
}
