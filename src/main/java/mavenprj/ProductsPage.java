package mavenprj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    By checkoutButton = By.id("checkout");
    By addToCartButton = By.xpath("//button[text()='Add to cart']");
    By cartIcon = By.cssSelector(".shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void addProductToCart(String productName) {

        //Look for product
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-"+productName+"\"]")).click();
        driver.findElement(By.linkText("1")).click();
    }
}