package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void checkUserNameField (){
        Assert.assertTrue(findElement(By.cssSelector("#username")).isDisplayed());
    }

    public void checkPasswordField (){
        Assert.assertTrue(findElement(By.cssSelector("#password")).isDisplayed());
    }

    public void checkSignInButton (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.pure-button-primary.button-success")).isDisplayed());
    }

    public void checkLogo (){
        Assert.assertTrue(findElement(By.cssSelector(".login-logo")).isDisplayed());
    }

    public void checkLoginMessage (){
        Assert.assertTrue(findElement(By.cssSelector(".login-msg")).isDisplayed());
    }

    public void enterUserName (String userName) {
        findElement(By.cssSelector("#username")).sendKeys(userName);
    }

    public void enterPassword (String password) {
        findElement(By.cssSelector("#password")).sendKeys(password);
    }

    public void submitSignInButton (){
        findElement(By.xpath("//button[@type='submit']")).isEnabled();
        findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void tryToOpenMainPageWithoutAutorization (){
        driver.get(mainPageURL);
        driver.manage().window().maximize();
    }

    public LoginPage login(String userName, String password) {
        findElement(By.cssSelector("#username")).sendKeys(userName);
        findElement(By.cssSelector("#password")).sendKeys(password);
        findElement(By.xpath("//button[@type='submit']")).isEnabled();
        findElement(By.xpath("//button[@type='submit']")).click();
        return new LoginPage(driver);
    }



}
