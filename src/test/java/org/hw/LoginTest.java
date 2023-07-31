package org.hw;

import org.hw.PagesHW15.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTestClass {

    @Test
    public void verifyLogin() {

        boolean loginIsSuccess = new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .enterUserPassword("secret_sauce")
                .clickLoginButton()
                .getMainContentVisibility();

        Assertions.assertTrue(loginIsSuccess);
    }
}
