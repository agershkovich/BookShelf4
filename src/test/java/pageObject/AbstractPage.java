package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by agershkovich on 8/31/2016.
 */
public class AbstractPage {
    protected WebDriver driver;
    public AbstractPage (WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage navigateToLoginPage() {
        driver.get("http://172.23.62.90:3000");
        Assert.assertTrue(driver.findElement(By.cssSelector(".bg-screen")).isDisplayed());
        return new LoginPage(driver);
    }

    public void closeDriver(){
        driver.quit();
    }

}
