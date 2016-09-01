package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage checkSignOut (){
        Assert.assertTrue(driver.findElement(By.cssSelector(".signout")).isDisplayed());
        return new MainPage(driver);
    }

    public MainPage checkFullUserName (String fullUserName){
        Assert.assertTrue(driver.findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).getText(),fullUserName);
        return new MainPage(driver);
    }


}
