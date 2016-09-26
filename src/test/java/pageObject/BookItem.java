package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookItem extends AbstractPage {
    public BookItem(WebDriver driver) {
        super(driver);
    }


    //Repository

    WebElement title = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]"));
    WebElement front = findElement(By.cssSelector(".book-content.anim.front"));
//    WebElement assignButton = driver.findElement(By.xpath("//a[@href='/app/books/7/assign']/button"));
    WebElement assignButton = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div[1]/a/button"));
//    WebElement assignButton = findElement(By.xpath("//button[@class='pure-button button-xl button-success']"));
//    WebElement assignButton = driver.findElement(By.linkText("Assign"));
    WebElement releaseButton = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[2]/div[2]/a/button"));
    WebElement editButton = findElement(By.linkText("Edit"));
    WebElement backButton = findElement(By.cssSelector(".pure-button.button-xl.button-warning"));
    WebElement actionsButton = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[6]/button"));
    WebElement deleteButton = findElement(By.cssSelector(".pure-button.button-xl.button-error"));
    WebElement viewButton = findElement(By.linkText("View"));
    public WebElement availableLabel = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[6]/div[2]/div"));
    WebElement label = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[1]/div[1]/span"));
    WebElement language = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/span"));





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
        Assert.assertTrue(releaseButton.isDisplayed());
    }
    public void bookItemEditButtonIsDisplayed (){
        Assert.assertTrue(editButton.isDisplayed());
    }
    public void bookItemBackButtonIsDisplayed (){
        Assert.assertTrue(backButton.isDisplayed());
    }
    public void bookItemFrontActionButtonIsDisplayed (){Assert.assertTrue(actionsButton.isDisplayed());}
    public void bookItemDeleteButtonIsDisplayed (){Assert.assertTrue(deleteButton.isDisplayed()); }
    public void bookItemViewButtonIsDisplayed (){
        Assert.assertTrue(viewButton.isDisplayed());
    }
    public void bookItemLabelIsDisplayed () {
        Assert.assertTrue(label.isDisplayed());}
    public void bookItemLanguageIsDisplayed () {Assert.assertTrue(language.isDisplayed());}

    public String bookItemAssignButtonState(){String state = assignButton.getAttribute("class").trim();
        return state;
    }

    public String releaseButtonState() {String state = releaseButton.getAttribute("class").trim();
        return state;
    }

    public void clickActionButton() { waitAndClick(actionsButton); }
    public void clickAssignButton() { waitAndClick(assignButton); }
    public void clickBackButton() {
        waitAndClick(backButton);
    }
    public void clickFront() {
        waitAndClick(front);
    }

}
