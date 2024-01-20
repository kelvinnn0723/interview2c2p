package mavenprj;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @Test
    public void UI_Test_1_loginSuccessfulTest() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToUrl("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");

        // Log the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //Assertions for successful login
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login was not successful");
    }

    @Test
    public void UI_Test_2_loginLockedOutUserTest() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToUrl("https://www.saucedemo.com/");
        loginPage.login("locked_out_user", "secret_sauce");

        // Log the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //Assertions for locked-out user login to check error message
        Assert.assertTrue(loginPage.getErrorMessage().contains("Sorry, this user has been locked out."));
    }

    @Test
    public void UI_Test_3_loginIncorrectPasswordTest() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToUrl("https://www.saucedemo.com/");
        loginPage.login("validUsername", "incorrectPassword");

        // Log the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //Assertions for incorrect password login
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match any user"));
    }
}
