package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public LoginPage enterUserName (String userName) {
        driver.findElement(By.cssSelector("#username")).sendKeys(userName);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword (String password) {
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage submitSignInButton (){
        driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return new LoginPage(driver);
    }

    public LoginPage tryToOpenMainPageWithoutAutorization (){
        driver.get("http://172.23.62.90:3000/app/books");
        driver.manage().window().maximize();
//        Assert.assertTrue(driver.findElement(By.cssSelector(".bg-screen")).isDisplayed());
        return new LoginPage(driver);
    }


}
