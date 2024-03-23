package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminPage extends BasePage{
    // Constructor
    public AdminPage(WebDriver driver) {
        super(driver);
    }


    // Elements Locators
    public By dashboardTitle = By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");
    public By numOfRecordsFound = By.xpath("//hr[starts-with(@class, 'oxd-divider')]/following-sibling::div/span");

    public By addBtn = By.cssSelector("div.orangehrm-header-container button.oxd-button"); // //button[contains(.,'Add')]
    public By userRoleDropdown = By.xpath("//label[.='User Role']/parent::div/following-sibling::div/descendant::div[contains(@class, 'oxd-select-text--active')]");
    public By adminUserRole = By.xpath("(//div[@role='listbox']//child::div)[2]");
    public By essUserRole = By.xpath("(//div[@role='listbox']//child::div)[3]");
    public By employeeNameField = By.xpath("//label[.='Employee Name']/parent::div/following-sibling::div/descendant::input[@placeholder='Type for hints...']");
    public By statusDropdown = By.xpath("//label[.='Status']/parent::div/following-sibling::div/descendant::div[contains(@class, 'oxd-select-text--active')]");
    public By enabledStatus = By.xpath("(//div[@role='listbox']//child::div)[2]");
    public By disabledStatus = By.xpath("(//div[@role='listbox']//child::div)[3]");
    public By usernameField = By.xpath("//label[.='Username']/parent::div/following-sibling::div/input[starts-with(@class, 'oxd-input')]");
    public By passwordField = By.xpath("//label[.='Password']/parent::div/following-sibling::div/input[starts-with(@class, 'oxd-input')]");
    public By confirmPasswordField = By.xpath("//label[.='Confirm Password']/parent::div/following-sibling::div/input[starts-with(@class, 'oxd-input')]");
    public By saveBtn = By.cssSelector("div.oxd-form-actions button[type='submit']");
    public By searchBtn = By.cssSelector("div.oxd-form-actions button[type='submit']");
    public By resetBtn = By.cssSelector("div.oxd-form-actions button[type='button']");
    public By deleteIcon = By.xpath("(//div[@class='oxd-table-cell-actions']/button)[1]");
    public By confirmDeletion = By.xpath("(//div[@class='orangehrm-modal-footer']/button)[2]");

    public void addNewUser(boolean isAdmin, String employee, boolean isEnabled, String username, String password, String confirmPassword) throws InterruptedException {
        click(addBtn);
        click(userRoleDropdown);
        if (isAdmin) {
            click(adminUserRole);
        } else {
            click(essUserRole);
        }
        enterTextFollowedByKeystrokes(employeeNameField, employee);
        click(statusDropdown);
        if (isEnabled) {
            click(enabledStatus);
        } else {
            click(disabledStatus);
        }
        setText(usernameField, username);
        setText(passwordField, password);
        setText(confirmPasswordField, confirmPassword);
        click(saveBtn);
    }
    public void searchForAUserAndDelete(String employee, String username) throws InterruptedException {
        setText(usernameField, username);
        enterTextFollowedByKeystrokes(employeeNameField, employee);
        click(searchBtn);
        click(deleteIcon);
        click(confirmDeletion);
        click(resetBtn);
    }
}
