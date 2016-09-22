package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.*;


public class Steps {
    String loginPageURL = "http://172.23.62.90:3000";
    String mainPageURL = loginPageURL + "/app/books";

    private WebDriver driver = new FirefoxDriver();

    LoginPage loginPage;
    MainPage mainPage;
    BookItem bookItem;
    AssignBookPage assignBookPage;
    DetailPage detailPage;

    String selectedBook;

    @Given("^I am on the Login page$")
    public void i_am_on_the_login_page() {
       loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @When("Login field displayed$")
    public void login_field_displayed() {
        loginPage.checkUserNameField();
    }


    @And("Password field displayed$")
    public void password_field_displayed() {
        loginPage.checkPasswordField();
    }

    @And("Sign In button displayed$")
    public void sign_In_button_displayed() {
        loginPage.checkSignInButton();
    }

    @And("Logo displayed")
    public void logo_displayed() {
        loginPage.checkLogo();
    }

    @Then("Login Message displayed")
    public void login_Message_displayed() {
        loginPage.checkLoginMessage();
    }

    @And("I close a browser")
    public void i_close_a_browser() {
        loginPage.closeDriver();
    }

    @And("^User filed \"([^\"]*)\" and \"([^\"]*)\" fields with LOHIKA creds$")
    public void user_filed_and_fields_with_LOHIKA_creds(String userName, String password) throws Throwable {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @And("^User click Sign In button$")
    public void user_click_Sign_In_button() throws Throwable {
        mainPage = new MainPage(driver);
        loginPage.submitSignInButton();
    }

    @And("^User redirect to Main Page of BookShelf$")
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

    @And("^Login with admin \"([^\"]*)\" and \"([^\"]*)\"$")
    public void login_with_admin_and(String userName, String password) throws Throwable {
        loginPage.login(userName, password);
    }

    @And("^User browse to Book List View$")
    public void user_browse_to_Book_List_View() throws Throwable {
        mainPage = new MainPage(driver);
        mainPage.checkPageURL(mainPageURL);

    }

    @And("^User see an Action button in the Book Item$")
    public void user_see_an_Action_button_in_the_Book_Item() throws Throwable {
        bookItem = new BookItem(driver);
        bookItem.bookItemFrontActionButtonIsDisplayed();
    }

    @And("^User click Action button$")
    public void user_click_action_button() throws Throwable {
        bookItem.clickActionButton();
    }

    @And("^User see Back View of Book Item$")
    public void user_see_back_view_of_book_item() throws Throwable {
        bookItem = new BookItem(driver);
        bookItem.bookItemAssignButtonIsDisplayed();
        bookItem.bookItemReleaseDIsabledButtonIsDisplayed();
        bookItem.bookItemEditButtonIsDisplayed();
        bookItem.bookItemBackButtonIsDisplayed();
        bookItem.bookItemDeleteButtonIsDisplayed();
        bookItem.bookItemViewButtonIsDisplayed();
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

    @When("^Admin browse to Assign Book View$")
    public void admin_browse_to_Assign_Book_View () throws Throwable {

        }

    @Then("^All UI elements of Assign Book page are presented$")
    public void all_ui_elements_assign_book_page_are_presented() throws Throwable {
//        assignBookPage = new AssignBookPage(driver);
        assignBookPage.assignFormBookDropDownListIsDisplayed();
        assignBookPage.assignFormUserDropDownListIsDisplayed();
        assignBookPage.assignFormAssignBookButtonIsDisplayed();
        assignBookPage.assignFormBackButtonIsDisplayed();
        assignBookPage.assignFormTitleIsDisplayed();
    }

    /////Scenario 3

    @Given("^I am on the Main page with admin \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_am_on_the_Main_page_with_admin_and(String userName, String password) throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login(userName, password);
        mainPage = new MainPage(driver);
        mainPage.checkPageURL(mainPageURL);
    }

    @Given("^User sees a Books's title in the Book Item$")
    public void user_see_a_Books_s_title_in_the_Book_Item() throws Throwable {
        bookItem = new BookItem(driver);
        bookItem.bookItemTitleIsDisplayed();
        selectedBook = bookItem.getSelectedBookName();

    }

    @And("^User sees an Assing Book form$")
    public void user_sees_an_Assing_Book_form() throws Throwable {
//        bookItem = new BookItem(driver);
//        bookItem.bookItemFrontActionButtonIsDisplayed();
//        bookItem.clickActionButton();
//        bookItem.clickAssignButton();
//        assignBookPage = new AssignBookPage(driver);
        bookItem.clickActionButton();
        bookItem = new BookItem(driver);
        bookItem.clickAssignButton();
//        assignBookPage = new AssignBookPage(driver);


    }

    @Then("^The value in Assign Book field is equal to Book's title that was selected in Book list view$")
    public void the_value_in_Assign_Book_field_is_equal_to_Book_s_title_that_was_selected_in_Book_list_view() throws Throwable {
        assignBookPage = new AssignBookPage(driver);
        assignBookPage.assignFormBookDropDownListIsDisplayed();
        String assignedBook = assignBookPage.getAssignedBookName();
        Assert.assertEquals("Book names aren't equal", assignedBook, selectedBook);

    }

    //Scenario 5

    @Given("^Admin on Assign Book Page as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void admin_on_Assign_Book_Page_as_and(String userName, String password) throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login(userName, password);
        bookItem = new BookItem(driver);
        bookItem.bookItemFrontActionButtonIsDisplayed();
        bookItem.clickActionButton();
        bookItem = new BookItem(driver);
        bookItem.clickAssignButton();
        assignBookPage = new AssignBookPage(driver);
    }

    @When("^Admin sees User List$")
    public void admin_see_User_List() throws Throwable {
        assignBookPage.assignFormUserDropDownListIsDisplayed();
    }

    @Then("^Admin can choose \"([^\"]*)\"$")
    public void admin_can_choose(String string) throws Throwable {
        assignBookPage.sendKeysToUserList(string);
        Assert.assertEquals("User name isn't equal", string, assignBookPage.getSelectedUser());
    }

    //Scenario 6

    @When("^Admin assign book to User \"([^\"]*)\"$")
    public void admin_assign_book_to_User(String string) throws Throwable {
        assignBookPage.sendKeysToUserList(string);
        assignBookPage.pressAssignButton();
    }

    @Then("^Assign button becomes inactive$")
    public void assign_button_becomes_inactive() throws Throwable {
        bookItem = new BookItem(driver);
        Assert.assertEquals("pure-button button-xl button-success pure-button-disabled", bookItem.bookItemAssignButtonState());
    }

    @Then("^Release button becomed active$")
    public void release_button_becomed_active() throws Throwable {
        Assert.assertEquals("pure-button button-xl button-error",bookItem.releaseButtonState());
    }

    @Then("^On Hands label appears$")
    public void on_Hands_label_appears() throws Throwable {
        bookItem.clickBackButton();
        Assert.assertTrue(bookItem.availableLabel.isDisplayed());
        Assert.assertEquals("On hands", bookItem.availableLabel.getText().trim());

    }

    //Scenario 7

    @When("^Admin clicks Back button$")
    public void admin_clicks_Back_button() throws Throwable {
        assignBookPage.waitAndClick(assignBookPage.btnBack);
    }

    @Then("^Admin redirected to Main Page$")
    public void admin_redirected_to_Main_Page() throws Throwable {
        mainPage = new MainPage(driver);
        mainPage.checkPageURL(mainPageURL);
    }

    //Scenario 8

    @When("^Admin sees Available label if book is free$")
    public void admin_sees_Available_label_if_book_is_free() throws Throwable {
        bookItem = new BookItem(driver);
        Assert.assertTrue(bookItem.availableLabel.isDisplayed());
        Assert.assertEquals("Available", bookItem.availableLabel.getText().trim());
    }

    @Then("^Available Label is green$")
    public void available_label_is_green() throws Throwable {
        String colour = bookItem.availableLabel.getAttribute("class");
        Assert.assertEquals("text-success", colour);
        System.out.println(colour);
    }


    ///Details Page

    //Scenario 1 DrillDown to Details Page

    @When("^I click on the Book Item$")
    public void i_click_on_the_Book_Item() throws Throwable {
        bookItem = new BookItem(driver);
        bookItem.bookItemTitleIsDisplayed();
        selectedBook = bookItem.getSelectedBookName();
        bookItem.clickFront();
    }

    @Then("^I routed to Detail Page$")
    public void i_routed_to_Detail_Page() throws Throwable {
        detailPage = new DetailPage(driver);
        String detailPageBookName = detailPage.getDetailedBookName();
        Assert.assertEquals("Book names aren't equal", detailPageBookName, selectedBook);

    }

    @Then("^Footer and Add Book Item are present on Main page$")
    public void footer_and_add_book_item_are_present_on_main_page() throws Throwable {
        mainPage.isFooterDisplayed();
        mainPage.addBookItemDisplayed();
    }




}
