package mavenprj.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    WebDriver driver = new ChromeDriver();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        
        driver.get("ttps://www.saucedemo.com/");
        System.out.println("Navigating to the login page");
    }

    @When("the user enters valid credentials")
    public void whenTheUserEntersValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("loginButton")).click();
        System.out.println("Entering valid credentials");
    }

    @Then("the user should be logged in")
    public void thenTheUserShouldBeLoggedIn() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login was not successful");
        System.out.println("Verifying that the user is logged in");
        driver.quit();
    }
    
}
