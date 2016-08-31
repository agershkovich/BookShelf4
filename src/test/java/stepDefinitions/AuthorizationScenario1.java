package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.LoginPage;


public class AuthorizationScenario1 {

    WebDriver driver = new FirefoxDriver();
    LoginPage loginPage;

    @Given("^I am on the Login page$")
    public void i_am_on_the_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Then("Login field displayed$")
    public void login_field_displayed() {
//          Assert.assertTrue(driver.findElement(By.cssSelector("#username")).isDisplayed());
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
        driver.quit();
    }


}
