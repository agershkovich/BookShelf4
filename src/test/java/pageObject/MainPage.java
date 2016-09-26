package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class MainPage extends AbstractPage {



    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void checkFullUserName (String fullUserName){
        Assert.assertTrue(findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).isDisplayed());
        Assert.assertEquals(findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).getText(),fullUserName);
    }










}
