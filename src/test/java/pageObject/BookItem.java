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
    WebElement assignButton = driver.findElement(By.linkText("Assign"));
    WebElement releaseDisabledButton = driver.findElement(By.cssSelector(".pure-button.button-xl.button-error.pure-button-disabled"));
    WebElement editButton = driver.findElement(By.linkText("Edit"));
    WebElement backButton = driver.findElement(By.cssSelector(".pure-button.button-xl.button-warning"));
    WebElement actionsButton = driver.findElement(By.cssSelector(".pure-button.more-button"));
    WebElement deleteButton = driver.findElement(By.cssSelector(".pure-button.button-xl.button-error"));
    WebElement viewButton = driver.findElement(By.linkText("View"));
    public WebElement availableLabel = driver.findElement(By.cssSelector("div.text-success"));


    public String getSelectedBookName(){
        String titleText = title.getText();
        System.out.println(titleText);
        return titleText;

    }

    public void bookItemTitleIsDisplayed (){
        Assert.assertTrue(title.isDisplayed());
    }


    public void bookItemAssignButtonIsDisplayed (){
        Assert.assertTrue(assignButton.isDisplayed());
    }

    public void bookItemReleaseDIsabledButtonIsDisplayed (){
        Assert.assertTrue(releaseDisabledButton.isDisplayed());
    }

    public void bookItemEditButtonIsDisplayed (){
        Assert.assertTrue(editButton.isDisplayed());
    }

    public void bookItemBackButtonIsDisplayed (){
        Assert.assertTrue(backButton.isDisplayed());
    }

    public void bookItemFrontActionButtonIsDisplayed (){
        Assert.assertTrue(actionsButton.isDisplayed());
    }

    public void bookItemDeleteButtonIsDisplayed (){
        Assert.assertTrue(deleteButton.isDisplayed());
    }

    public void bookItemViewButtonIsDisplayed (){
        Assert.assertTrue(viewButton.isDisplayed());
    }


    public void clickActionButton() {
        waitAndClick(actionsButton);
    }

    public void clickAssignButton() {
        waitAndClick(assignButton);
    }

    public void clickBackButton() {
        waitAndClick(backButton);
    }

    public void clickFront() {
        waitAndClick(front);
    }


}
