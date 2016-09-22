package pageObject;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

/**
 * Created by agershkovich on 8/31/2016.
 */
public class AbstractPage{
     String loginPageURL = "http://172.23.62.90:3000";
     String mainPageURL = loginPageURL + "/app/books";

    protected WebDriver driver;



    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    public AbstractPage (WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public LoginPage navigateToLoginPage() {
        driver.get(loginPageURL);
        driver.manage().window().maximize();
        Assert.assertTrue(findElement(By.cssSelector(".bg-screen")).isDisplayed());
        return new LoginPage(driver);
    }
    //Actions
    public void waitAndClick (WebElement webElement) {
        if (webElement.isDisplayed()) {
            webElement.click();
        }

    }

    private void highLight(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
            try {
                Thread.sleep(300);
            } catch (Exception ex) { }
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            try {
                Thread.sleep(300);
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
        driver.quit();String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

        public void checkPageURL (String pageURL){
            String currentURL = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentURL);
            Assert.assertEquals(currentURL,pageURL);
        }






    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}





