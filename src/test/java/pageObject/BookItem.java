package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by agershkovich on 9/2/2016.
 */
public class BookItem extends AbstractPage {
    public BookItem(WebDriver driver) {
        super(driver);
    }


    //Repository

    WebElement title = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]"));
    WebElement front = findElement(By.cssSelector(".book-content.anim.front"));
//    WebElement assignButton = driver.findElement(By.xpath("//a[@href='/app/books/7/assign']/button"));
//    WebElement assignButton = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div[1]/a/button"));
    WebElement assignButton = driver.findElement(By.linkText("Assign"));
    WebElement releaseDisabledButton = findElement(By.cssSelector(".pure-button.button-xl.button-error.pure-button-disabled"));
    WebElement editButton = findElement(By.linkText("Edit"));
    WebElement backButton = findElement(By.cssSelector(".pure-button.button-xl.button-warning"));
    WebElement actionsButton = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[6]/button"));
    WebElement deleteButton = findElement(By.cssSelector(".pure-button.button-xl.button-error"));
    WebElement viewButton = findElement(By.linkText("View"));
    public WebElement availableLabel = findElement(By.cssSelector("div.text-success"));


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
//        ExpectedConditions.elementToBeClickable(assignButton);
        waitAndClick(assignButton);
    }

    public void clickBackButton() {
        waitAndClick(backButton);
    }

    public void clickFront() {
        waitAndClick(front);
    }


}
