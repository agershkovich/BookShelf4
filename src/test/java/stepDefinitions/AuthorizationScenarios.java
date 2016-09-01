package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.LoginPage;
import pageObject.MainPage;


public class AuthorizationScenarios {

    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage;
    MainPage mainPage;

    @Given("^I am on the Login page$")
    public void i_am_on_the_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Then("Login field displayed$")
    public void login_field_displayed() {
        loginPage.checkUserNameField();
    }


    @Then("Password field displayed$")
    public void password_field_displayed(){
//        Assert.assertTrue(driver.findElement(By.cssSelector("#password")).isDisplayed());
        loginPage.checkPasswordField();
    }

    @Then("Sign In button displayed$")
    public void sign_In_button_displayed(){
//        Assert.assertTrue(driver.findElement(By.cssSelector(".pure-button.pure-button-primary.button-success")).isDisplayed());
        loginPage.checkSignInButton();
    }

    @Then("Logo displayed")
    public void logo_displayed() {
//        Assert.assertTrue(driver.findElement(By.cssSelector(".login-logo")).isDisplayed());
        loginPage.checkLogo();
    }

    @Then("Login Message displayed")
    public void login_Message_displayed() {
//        Assert.assertTrue(driver.findElement(By.cssSelector(".login-msg")).isDisplayed());
        loginPage.checkLoginMessage();
    }

    @Then("I close a browser")
    public void i_close_a_browser(){
        loginPage.closeDriver();
    }

    @Then("^User filed \"([^\"]*)\" and \"([^\"]*)\" fields with LOHIKA creds$")
    public void user_filed_and_fields_with_LOHIKA_creds(String userName, String password) throws Throwable {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @When("^User click Sign In button$")
    public void user_click_Sign_In_button() throws Throwable {
        mainPage = new MainPage(driver);
        loginPage.submitSignInButton();
//        driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("^User redirect to Main Page of BookShelf$")
    public void user_redirect_to_Main_Page_of_BookShelf() throws Throwable {
        mainPage.checkSignOut();
    }

    @Then("^\"([^\"]*)\" is displayed in Header$")
    public void is_displayed_in_Header(String fullUserName) throws Throwable {
        mainPage.checkFullUserName(fullUserName);
    }

    @When("^User tries to open /app/books route without authorization$")
    public void user_tries_to_open_app_books_route_without_authorization() throws Throwable {
    }

    @When("^User navigate to /app/books route without authorization$")
    public void user_navigate_to_app_books_route_without_authorization() throws Throwable {
    }

    @Then("^User redirect to Login view$")
    public void user_redirect_to_Login_view() throws Throwable {
    }


}
