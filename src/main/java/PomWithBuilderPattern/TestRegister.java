package PomWithBuilderPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRegister {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/register");;
    }

    @Test
    public void testRegister(){
       Register register = new Register.RegisterBuilder()
               .setUsername("Amit")
               .setPassword("123456")
               .setConfirmPassword("123456")
               .build();
       RegisterPage registerPage = new RegisterPage(driver);
       registerPage.userRegister(register);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
