package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.AssignBookPage;
import pageObject.LoginPage;
import pageObject.MainPage;

public class AssignBookScenarios extends AbstractScenarios{

//    WebDriver driver = new FirefoxDriver();
//    WebDriver driver = getDriver();

//    LoginPage loginPage;
//    MainPage mainPage;
//    AssignBookPage assignBookPage;


    @Then("^Login with admin \"([^\"]*)\" and \"([^\"]*)\"$")
    public void login_with_admin_and(String arg1, String arg2) throws Throwable {
    }

    @When("^User browse to Book List View$")
    public void user_browse_to_Book_List_View() throws Throwable {
    }

    @Then("^User see an Assign button in the Book Item$")
    public void user_see_an_Assign_button_in_the_Book_Item() throws Throwable {
    }

    @Then("^User click a button$")
    public void user_click_a_button() throws Throwable {
    }

    @Then("^User redirected to Assign Book View$")
    public void user_redirected_to_Assign_Book_View() throws Throwable {
    }


}
