package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AssignBookPage extends AbstractPage{
    public AssignBookPage(WebDriver driver) {
        super(driver);
    }

    //  Repository
    WebElement btnAssignBook = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[3]/button[2]"));
    WebElement btnBack = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[3]/button[1]"));
    WebElement ttlAssignBookForm = driver.findElement(By.cssSelector(".title>h2"));
    WebElement ddlAssignBook = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[1]/select"));
    WebElement ddlToUser = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[2]/div/div/div"));

    public void assignFormAssignBookButtonIsDisplayed (){
        Assert.assertTrue(btnAssignBook.isDisplayed());
    }

    public void assignFormBackButtonIsDisplayed (){
        Assert.assertTrue(btnBack.isDisplayed());
    }

    public void assignFormTitleIsDisplayed (){
        Assert.assertTrue(ttlAssignBookForm.isDisplayed());
    }

    public void assignFormBookDropDownListIsDisplayed (){
     Assert.assertTrue(ddlAssignBook.isDisplayed());

    }

    public void assignFormUserDropDownListIsDisplayed (){
        Assert.assertTrue(ddlToUser.isDisplayed());
    }

//    public  int getItemNumber() {
//        String url = driver.getCurrentUrl();
//        String[] location = url.split("/");
//        int iNumber = Integer.parseInt(location[5]);
//        return iNumber;
//
//    }

    public String getAssignedBookName () {
        Select dropDownBook = new Select(driver.findElement(By.name("book")));
        String assignedBookName = dropDownBook.getFirstSelectedOption().getText();
        System.out.println(assignedBookName);
        return assignedBookName;

    }


















}
