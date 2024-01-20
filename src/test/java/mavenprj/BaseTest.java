package mavenprj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        
        //Change the directory of chrome webdriver to match with the directory of your chrome webdriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\KXL12061.ONE\\Desktop\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
