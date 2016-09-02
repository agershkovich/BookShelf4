package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by agershkovich on 9/2/2016.
 */
public class BookItem extends AbstractPage {
    public BookItem(WebDriver driver) {
        super(driver);
    }

    public void bookItemFrontIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".book-content.anim.front")).isDisplayed());
    }

    public void bookItemAssignButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.button-xl.button-success")).isDisplayed());
    }

    public void bookItemReleaseDIsabledButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.button-xl.button-error.pure-button-disabled")).isDisplayed());
    }

    public void bookItemEditButtonIsDisplayed (){
//        Assert.assertTrue(findElement(By.cssSelector(".pure-button.button-xl")).isDisplayed());
        Assert.assertTrue(findElement(By.linkText("Edit")).isDisplayed());
    }

    public void bookItemBackButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.button-xl.button-warning")).isDisplayed());
    }

    public void bookItemFrontActionButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.more-button")).isDisplayed());
    }


    public void clickActionButton() {
        findElement(By.cssSelector(".pure-button.more-button")).isEnabled();
        findElement(By.cssSelector(".pure-button.more-button")).click();
    }

    public void clickAssignButton() {
        findElement(By.cssSelector(".pure-button.button-xl.button-success")).isEnabled();
        findElement(By.cssSelector(".pure-button.button-xl.button-success")).click();
    }

    public void clickBackButton() {
        findElement(By.cssSelector(".pure-button.button-xl.button-warning")).isEnabled();
        findElement(By.cssSelector(".pure-button.button-xl.button-warning")).click();
    }




}
