package mavenprj;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;

    @Test
    public void UI_Test_4_checkoutCompleteTest() {
        // Create an instance of the Login Page
        loginPage = new LoginPage(driver);

        //Navigate to URL
        loginPage.navigateToUrl("https://www.saucedemo.com/");

        // Login with valid credentials
        loginPage.login("standard_user", "secret_sauce");

        //Create an instance of the Product Page
        productsPage = new ProductsPage(driver);

        //Add Product To Cart
        productsPage.addProductToCart("sauce-labs-backpack");

        //Click the checkout button
        productsPage.clickCheckoutButton();

        //Create an instance of the CheckoutPage
        checkoutPage = new CheckoutPage(driver);
        
        //Fill shipping information
        checkoutPage.fillShippingInformation("Kelvin", "Lon", "57000");
        
        //Complete the checkout
        checkoutPage.completeCheckout();
        
        //Assertions the checkout complete scenario
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
        
    }
}
