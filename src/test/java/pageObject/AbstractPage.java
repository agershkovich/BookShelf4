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
//            System.out.println("Current URL: " + currentURL);
            Assert.assertEquals(currentURL,pageURL);
        }

    public void  clickSignOut(){waitAndClick(findElement(By.cssSelector(".signout")));}
    public void clickLogo() {waitAndClick(findElement(By.cssSelector(".logo")));}

    public void checkSignOut (){
        Assert.assertTrue(findElement(By.cssSelector(".signout")).isDisplayed());
    }
    public void isFooterDisplayed() {Assert.assertTrue(findElement(By.cssSelector("div.footer > div")).isDisplayed());}
    public void addBookItemDisplayed() {Assert.assertTrue(findElement(By.cssSelector(".fa.fa-plus-square-o.add-icon-custom")).isDisplayed());}
    public void isLogoDisplayed(){Assert.assertTrue(findElement(By.cssSelector(".logo")).isDisplayed()); }
    public void isSearchButtonDisplayed(){Assert.assertTrue(findElement(By.cssSelector(".search-button")).isDisplayed());}
    public void isSearchInputDisplayed(){Assert.assertTrue(findElement(By.cssSelector(".pure-form>fieldset")).isDisplayed());}
    public void isMenuDisplayed(){Assert.assertTrue(findElement(By.cssSelector(".mainmenu.text-primary")).isDisplayed());}
    public void isUserInfoDisplayed(){Assert.assertTrue(findElement(By.cssSelector(".user-info")).isDisplayed());}
    public void isHeaderDisplayed(){Assert.assertTrue(findElement(By.xpath(".//*[@id='content']/div/div/div/div[2]/div")).isDisplayed());}






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





