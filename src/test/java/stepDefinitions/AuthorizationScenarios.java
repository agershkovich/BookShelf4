package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.AssignBookPage;
import pageObject.BookItem;
import pageObject.LoginPage;
import pageObject.MainPage;


public class AuthorizationScenarios {
    String loginPageURL = "http://172.23.62.90:3000";
    String mainPageURL = loginPageURL + "/app/books";



    private WebDriver driver = new FirefoxDriver();

    LoginPage loginPage;
    MainPage mainPage;
    BookItem bookItem;
    AssignBookPage assignBookPage;

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
    public void password_field_displayed() {
        loginPage.checkPasswordField();
    }

    @Then("Sign In button displayed$")
    public void sign_In_button_displayed() {
        loginPage.checkSignInButton();
    }

    @Then("Logo displayed")
    public void logo_displayed() {
        loginPage.checkLogo();
    }

    @Then("Login Message displayed")
    public void login_Message_displayed() {
        loginPage.checkLoginMessage();
    }

    @Then("I close a browser")
    public void i_close_a_browser() {
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
    }

    @Then("^User redirect to Main Page of BookShelf$")
    public void user_redirect_to_Main_Page_of_BookShelf() throws Throwable {
        mainPage.checkSignOut();
    }

    @Then("^\"([^\"]*)\" is displayed in Header$")
    public void is_displayed_in_Header(String fullUserName) throws Throwable {
        mainPage.checkFullUserName(fullUserName);
    }

    @When("^User navigate to /app/books route without authorization$")
    public void user_tries_to_open_app_books_route_without_authorization() throws Throwable {
        loginPage.tryToOpenMainPageWithoutAutorization();
    }

    @Then("^User redirect to Login view$")
    public void user_redirect_to_Login_view() throws Throwable {
        loginPage.checkSignInButton();
    }

    ///////////Assign Book Scenarios/////////////////
    //Scenario 1

    @Then("^Login with admin \"([^\"]*)\" and \"([^\"]*)\"$")
    public void login_with_admin_and(String userName, String password) throws Throwable {
        loginPage.login(userName, password);
    }

    @When("^User browse to Book List View$")
    public void user_browse_to_Book_List_View() throws Throwable {
        mainPage = new MainPage(driver);
        mainPage.checkPageURL(mainPageURL);

    }

    @Then("^User see an Action button in the Book Item$")
    public void user_see_an_Action_button_in_the_Book_Item() throws Throwable {
        bookItem = new BookItem(driver);
        bookItem.bookItemFrontActionButtonIsDisplayed();
    }

    @When("^User click Action button$")
    public void user_click_action_button() throws Throwable {
        bookItem.clickActionButton();
    }

    @Then("^User see Back View of Book Item$")
    public void user_see_back_view_of_book_item() throws Throwable {
        bookItem.bookItemAssignButtonIsDisplayed();
        bookItem.bookItemReleaseDIsabledButtonIsDisplayed();
        bookItem.bookItemEditButtonIsDisplayed();
        bookItem.bookItemBackButtonIsDisplayed();
    }

    @When("^User click Assign button$")
    public void user_click_assign_button() throws Throwable {
        bookItem.clickAssignButton();
    }

    @When("^User click Back button$")
    public void user_click_back_button() throws Throwable {
        bookItem.clickBackButton();
    }


    @Then("^User redirected to Assign Book View$")
    public void user_redirected_to_Assign_Book_View() {
        assignBookPage = new AssignBookPage(driver);
        assignBookPage.assignFormAssignBookButtonIsDisplayed();

    }

    //Scenario 2

    @When("^User browse to Assign Book View as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_browse_to_Assign_Book_View_as_and(String userName, String password) throws Throwable {
        loginPage.login(userName, password);
        bookItem = new BookItem(driver);
        bookItem.clickActionButton();
        bookItem.clickAssignButton();

    }

    @Then("^User see an Assing Book form$")
    public void user_see_an_Assing_Book_form() throws Throwable {
        assignBookPage = new AssignBookPage(driver);
        assignBookPage.assignFormTitleIsDisplayed();
    }

    @Then("^Assign Book drop-down list displayed$")
    public void assign_Book_drop_down_list_displayed() throws Throwable {
        assignBookPage.assignFormBookDropDownListIsDisplayed();
    }

    @Then("^To User drop-down list displayed$")
    public void to_User_drop_down_list_displayed() throws Throwable {
        assignBookPage.assignFormUserDropDownListIsDisplayed();
    }

    @Then("^Assign book button displayed$")
    public void assign_book_button_displayed() throws Throwable {
        assignBookPage.assignFormAssignBookButtonIsDisplayed();
        assignBookPage.assignFormBackButtonIsDisplayed();
    }



}
