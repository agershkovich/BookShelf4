package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void checkSignOut (){
        Assert.assertTrue(findElement(By.cssSelector(".signout")).isDisplayed());
    }

    public void checkFullUserName (String fullUserName){
        Assert.assertTrue(findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).isDisplayed());
        Assert.assertEquals(findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).getText(),fullUserName);
    }


}
