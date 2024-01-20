package mavenprj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.cssSelector("*[data-test=\"continue\"]");
    By finishButton = By.cssSelector("*[data-test=\"finish\"]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillShippingInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(continueButton).click();
    }

    public void completeCheckout() {
        driver.findElement(finishButton).click();
    }
}
