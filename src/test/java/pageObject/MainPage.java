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
//        String  aaa = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div[1]/div/div/div[2]/a/span")).getText();
        Assert.assertEquals(driver.findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).getText(),fullUserName);
        String  aaa = driver.findElement(By.cssSelector(".pure-xs-hidden.pure-sm-hidden.text-primary")).getText();
        System.out.println("Full Name: " +aaa);
        return new MainPage(driver);
    }
}
