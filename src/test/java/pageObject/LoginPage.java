package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by agershkovich on 8/31/2016.
 */
public class LoginPage extends AbstractPage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage checkUserNameField (){
        Assert.assertTrue(driver.findElement(By.cssSelector("#username")).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage checkPasswordField (){
        Assert.assertTrue(driver.findElement(By.cssSelector("#password")).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage checkSignInButton (){
        Assert.assertTrue(driver.findElement(By.cssSelector(".pure-button.pure-button-primary.button-success")).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage checkLogo (){
        Assert.assertTrue(driver.findElement(By.cssSelector(".login-logo")).isDisplayed());
        return new LoginPage(driver);
    }

    public LoginPage checkLoginMessage (){
        Assert.assertTrue(driver.findElement(By.cssSelector(".login-msg")).isDisplayed());
        return new LoginPage(driver);
    }
}
