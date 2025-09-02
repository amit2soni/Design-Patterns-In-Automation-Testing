package WebDriverWithFactoryPattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = DriverFactory.getDriver("edge").createDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void loginTest(){
        Assert.assertEquals(driver.getTitle(),"Google");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
