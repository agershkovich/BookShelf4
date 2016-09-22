package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AssignBookPage extends AbstractPage{
    public AssignBookPage(WebDriver driver) {
        super(driver);
    }

    //  Repository
    WebElement btnAssignBook = findElement(By.xpath("//button[@type='submit']"));
    public WebElement btnBack = findElement(By.xpath("//button[@type='button']"));
    WebElement ttlAssignBookForm = findElement(By.cssSelector(".title>h2"));
    WebElement ddlAssignBook = findElement(By.xpath(".//*[@id='content']/div/div/div/div[3]/div/div/div/div[3]/form/fieldset/div[1]/select"));
    WebElement ddlToUser = findElement(By.cssSelector("div.rc-select-selection__rendered"));
    WebElement ddlToUserInput = findElement(By.cssSelector("input.rc-select-search__field"));

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


    public String getAssignedBookName () {
        Select dropDownBook = new Select(findElement(By.name("book")));
        String assignedBookName = dropDownBook.getFirstSelectedOption().getText();
        System.out.println(assignedBookName);
        return assignedBookName;

    }

    public String getSelectedUser () {
        String getSelectedUser = ddlToUser.getText();
        return getSelectedUser;


    }

    public void sendKeysToUserList (String string) {
//        driver.findElement(By.cssSelector("div.rc-select-selection__rendered")).click();
        ddlToUser.click();
        ddlToUserInput.clear();
        ddlToUserInput.sendKeys(string);
        ddlToUserInput.sendKeys(Keys.RETURN);


    }


















}
