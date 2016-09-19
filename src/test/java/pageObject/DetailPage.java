package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agershkovich on 9/16/2016.
 */
public class DetailPage extends AbstractPage{
    public DetailPage(WebDriver driver) {
        super(driver);
    }

    //Repository

    WebElement titleDetailedPage = driver.findElement(By.cssSelector("div.property-value.pure-u-2-5 > div"));



    public String getDetailedBookName(){
        String titleDetailedText = titleDetailedPage.getText();
        System.out.println(titleDetailedText);
        return titleDetailedText;

    }



}
