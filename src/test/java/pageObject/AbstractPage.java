package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agershkovich on 8/31/2016.
 */
public class AbstractPage{
    protected WebDriver driver;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }


    public LoginPage navigateToLoginPage() {
        driver.get("http://172.23.62.90:3000");
        driver.manage().window().maximize();
        Assert.assertTrue(findElement(By.cssSelector(".bg-screen")).isDisplayed());
        return new LoginPage(driver);
    }

    private void highLight(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            try {
                Thread.sleep(100);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
            try {
                Thread.sleep(100);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            try {
                Thread.sleep(100);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
        }
    }

    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        highLight(element);
        driver.findElement(by);
        return element;
    }

    public void closeDriver(){
        driver.quit();
    }

}
