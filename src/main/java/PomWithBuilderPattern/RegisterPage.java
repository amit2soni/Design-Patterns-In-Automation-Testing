package PomWithBuilderPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    By username = By.id("username");

    By password = By.id("password");

    By confirmPassword = By.id("confirmPassword");

    By registerBtn = By.xpath("//button[text()='Register']");

    public void userRegister(Register register){
        driver.findElement(username).sendKeys(register.getUsername());
        driver.findElement(password).sendKeys(register.getPassword());
        driver.findElement(confirmPassword).sendKeys(register.getConfirmPassword());
        driver.findElement(registerBtn).click();
    }

}
