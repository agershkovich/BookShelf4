package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agershkovich on 9/2/2016.
 */
public class BookItem extends AbstractPage {
    public BookItem(WebDriver driver) {
        super(driver);
    }

    //Repository

    WebElement title = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]"));
    WebElement front = driver.findElement(By.cssSelector(".book-content.anim.front"));


    public String getSelectedBookName(){
        String titleText = title.getText();
        System.out.println(titleText);
        return titleText;

    }

    public void bookItemTitleIsDisplayed (){
        Assert.assertTrue(title.isDisplayed());
    }


    public void bookItemAssignButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.linkText("Assign")).isDisplayed());
    }

    public void bookItemReleaseDIsabledButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.button-xl.button-error.pure-button-disabled")).isDisplayed());
    }

    public void bookItemEditButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.linkText("Edit")).isDisplayed());
    }

    public void bookItemBackButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.button-xl.button-warning")).isDisplayed());
    }

    public void bookItemFrontActionButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.more-button")).isDisplayed());
    }

    public void bookItemDeleteButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.cssSelector(".pure-button.button-xl.button-error")).isDisplayed());
    }

    public void bookItemViewButtonIsDisplayed (){
        Assert.assertTrue(findElement(By.linkText("View")).isDisplayed());
    }


    public void clickActionButton() {
        findElement(By.cssSelector(".pure-button.more-button")).isEnabled();
        findElement(By.cssSelector(".pure-button.more-button")).click();
    }

    public void clickAssignButton() {
        findElement(By.linkText("Assign")).isEnabled();
        findElement(By.linkText("Assign")).click();
    }

    public void clickBackButton() {
        findElement(By.cssSelector(".pure-button.button-xl.button-warning")).isEnabled();
        findElement(By.cssSelector(".pure-button.button-xl.button-warning")).click();
    }

    public void clickFront() {
        front.isEnabled();
        front.click();
    }


}
