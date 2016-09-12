package pageObject;

import org.junit.Assert;
import org.junit.rules.Verifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignBookPage extends AbstractPage{
    public AssignBookPage(WebDriver driver) {
        super(driver);
    }

    public void assignFormAssignBookButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[3]/button[2]")).isDisplayed());
    }

    public void assignFormBackButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[3]/button[1]")).isDisplayed());
    }

    public void assignFormTitleIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".title>h2")).isDisplayed());
    }

    public void assignFormBookDropDownListIsDisplayed (){
     Assert.assertTrue(findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[1]/select")).isDisplayed());

    }

    public void assignFormUserDropDownListIsDisplayed (){
        Assert.assertTrue(findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[2]/div/div/div")).isDisplayed());
    }






}
