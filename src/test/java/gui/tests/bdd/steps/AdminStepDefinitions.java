package gui.tests.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;
import pages.BasePage;
import pages.LoginPage;
import pages.partials.SideMenu;
import utils.JsonManager;

public class AdminStepDefinitions {
    private WebDriver driver;
    private BasePage basePage;
    private LoginPage loginPage;
    private SideMenu sideMenu;
    private AdminPage adminPage;
    private final JsonManager data = new JsonManager("users");
    int currentNumOfRecords;

    @Given("User launches the OrangeHRM")
    public void user_launches_the_orange_hrm() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        sideMenu = new SideMenu(driver);
        basePage = new BasePage(driver);
        adminPage= new AdminPage(driver);
    }
    @Given("User is on OrangeHRM login page")
    public void user_is_on_orange_hrm_login_page() {
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.navigate().to(url);
    }
    @When("User enters {string} as username")
    public void user_enters_as_username(String username) throws InterruptedException {
        loginPage.setUsername(username);
    }
    @When("User enters {string} as password")
    public void user_enters_as_password(String password) throws InterruptedException {
        loginPage.setPassword(password);
    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickOnLogin();
    }
    @When("User clicks on the Admin tab on the left side menu")
    public void user_clicks_on_the_admin_tab_on_the_left_side_menu() {
        sideMenu.NavigateToAdminTab();
    }
    @When("User gets the number of records found")
    public void user_gets_the_number_of_records_found() {
        currentNumOfRecords = basePage.extractNumber(adminPage.numOfRecordsFound);
    }
    @When("User clicks on the add button")
    public void user_clicks_on_the_add_button() {
        basePage.click(adminPage.addBtn);
    }
    @When("User fills the required data")
    public void user_fills_the_required_data() throws InterruptedException {
        basePage.click(adminPage.adminUserRole);
        basePage.enterTextFollowedByKeystrokes(adminPage.employeeNameField, data.getTestData("user.employeeName"));
        basePage.click(adminPage.enabledStatus);
        basePage.setText(adminPage.usernameField, data.getTestData("user.username"));
        basePage.setText(adminPage.passwordField, data.getTestData("user.password"));
        basePage.setText(adminPage. confirmPasswordField, data.getTestData("user.confirmPassword"));
    }
    @When("User clicks on the save button")
    public void user_clicks_on_the_save_button() {;
        basePage.click(adminPage.saveBtn);
    }
    @Then("Verify that the number of records increased by {int}")
    public void verify_that_the_number_of_records_increased_by(Integer int1) {
        Assert.assertEquals(currentNumOfRecords+=int1, basePage.extractNumber(adminPage.numOfRecordsFound));
    }
    @Then("User searches with the username for the new user")
    public void user_searches_with_the_username_for_the_new_user() throws InterruptedException {
        basePage.setText(adminPage.usernameField, data.getTestData("user.username"));
        basePage.enterTextFollowedByKeystrokes(adminPage.employeeNameField,  data.getTestData("user.employeeName"));
        basePage.click(adminPage.searchBtn);
    }
    @Then("User deletes the new user")
    public void user_deletes_the_new_user() {
        basePage.click(adminPage.deleteIcon);
        basePage.click(adminPage.confirmDeletion);
        basePage.click(adminPage.resetBtn);
    }
    @Then("Verify that the number of records decreased by {int}")
    public void verify_that_the_number_of_records_decreased_by(Integer int1) {
        Assert.assertEquals(currentNumOfRecords-=int1, basePage.extractNumber(adminPage.numOfRecordsFound));
    }


}
